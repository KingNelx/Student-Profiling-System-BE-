package com.profiling.profilingbackend.Implementation;

import java.util.List;
import java.util.Optional;
import com.profiling.profilingbackend.Entity.Course;
import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Repository.CourseRepo;
import com.profiling.profilingbackend.Repository.StudentRepo;
import com.profiling.profilingbackend.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    @Transactional
    public ResponseEntity<String> addNewStudent(@RequestBody Student student) {

        Optional<Student> existingFirstName = studentRepo.findByFirstName(student.getFirstName());
        Optional<Student> existingLastName = studentRepo.findByLastName(student.getLastName());
        Optional<Student> existingStudentId = studentRepo.findByStudentId(student.getStudentId());

        boolean doesFirstNameExist = existingFirstName.isPresent();
        boolean doesLastNameExist = existingLastName.isPresent();
        boolean doesStudentIdExist = existingStudentId.isPresent();

        try {
            if (doesFirstNameExist && doesLastNameExist && doesStudentIdExist) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(" DATA ALREADY EXIST ");
            }
            List<Course> myCourse = student.getMyCourse();
            try {
                if (myCourse.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" COURSE CAN NOT BE EMPTY ");
                } else {
                    for (Course course : myCourse) {
                        courseRepo.save(course);
                    }
                    studentRepo.save(student);
                    return ResponseEntity.status(HttpStatus.OK).body(" NEW STUDENT ADDED ");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(" SOMETHING WENT WRONG " + e.getCause());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(" SOMETHING WENT WRONG " + e.getCause());
        }
    }

    @Override
    public List<Student> allStudents() {
        List<Student> allStudents = studentRepo.findAll();
        try {
            if (!allStudents.isEmpty()) {
                return allStudents;
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getCause());
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Optional<Student> queryStudentByID(@PathVariable String id) {
        Optional<Student> studentID = studentRepo.findById(id);
        try {
            if (studentID.isPresent()) {
                return studentID;
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getCause());
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<String> removeStudentData(@PathVariable String id) {
        Optional<Student> existingID = studentRepo.findById(id);
        try {
            if (existingID.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" STUDENT NOT FOUND ");
            }
            Student student = existingID.get();
            List<Course> myCourse = student.getMyCourse();
            studentRepo.deleteById(id);
            for (Course course : myCourse) {
                courseRepo.deleteById(course.getId());
            }
            return ResponseEntity.ok("Student and associated courses deleted successfully");
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getCause());
        }
    }

    @Override
    public ResponseEntity<String> updateStudentData(@RequestBody Student student, @PathVariable String id) {
        Student existingID = studentRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        try {
            if (existingID != null) {
                existingID.setFirstName(student.getFirstName());
                existingID.setMiddleInitial(student.getMiddleInitial());
                existingID.setLastName(student.getLastName());
                existingID.setDateOfBirth(student.getDateOfBirth());
                existingID.setGender(student.getGender());
                existingID.setTemporaryAddress(student.getTemporaryAddress());
                existingID.setPermanentAddress(student.getPermanentAddress());
                existingID.setContactInformation(student.getContactInformation());
                existingID.setAcademicLevel(student.getAcademicLevel());
                studentRepo.save(existingID);
                return ResponseEntity.status(HttpStatus.OK).body(" UPDATED SUCCESSFULLY ");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(" SOMETHING WENT WRONG " + e.getCause());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" STUDENT NOT FOUND ");
    }

    @Override
    public List<Student> queryAllMales() {
        List<Student> males = studentRepo.findByGender("MALE");

        try {
            if (males.isEmpty()) {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT, " THERE ARE NO STUDENTS AVAILABLE ");
            } else {
                return males;
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getCause());
        }
    }

    @Override
    public List<Student> queryAllFemales() {
        List<Student> females = studentRepo.findByGender("FEMALE");

        try {
            if (females.isEmpty()) {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT, " THERE ARE NO STUDENTS AVAILABLE ");
            } else {
                return females;
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getCause());
        }
    }

    @Override
    public List<Student> queryFreshman() {
        List<Student> allFreshman = studentRepo.findByAcademicLevel("FRESHMAN");
        try {
            if (allFreshman.isEmpty()) {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT, " NO DATA FOUND ");
            } else {
                return allFreshman;
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getCause());
        }
    }

    @Override
    public List<Student> querySophomore() {
        List<Student> allSophomore = studentRepo.findByAcademicLevel("SOPHOMORE");

        try {
            if (allSophomore.isEmpty()) {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT, " NO DATA FOUND ");
            } else {
                return allSophomore;
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getCause());
        }
    }

    @Override
    public List<Student> queryJunior() {
        List<Student> allJunior = studentRepo.findByAcademicLevel("JUNIOR");

        try {
            if (allJunior.isEmpty()) {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT, " NO DATA FOUND ");
            } else {
                return allJunior;
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getCause());
        }
    }

    @Override
    public List<Student> querySenior() {
        List<Student> allSenior = studentRepo.findByAcademicLevel("SENIOR");

        try {
            if (allSenior.isEmpty()) {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT, " NO DATA FOUND ");
            } else {
                return allSenior;
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getCause());
        }
    }

    @Override
    public Long totalStudentCount() {
        Long male = studentRepo.count();
        return male;
    }

    @Override
    public Long totalMaleCount() {
        Long countMale = studentRepo.countByGender("MALE");

        if (countMale.longValue() < 0) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        } else {
            return countMale;
        }
    }

    @Override
    public Long totalFemaleCount() {
        Long countFemale = studentRepo.countByGender("FEMALE");
        if (countFemale.longValue() < 0) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        } else {
            return countFemale;
        }
    }

}
