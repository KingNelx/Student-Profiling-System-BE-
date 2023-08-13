package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Entity.StudentEducationalBackground;
import com.profiling.profilingbackend.Entity.StudentFamilyBackground;
import com.profiling.profilingbackend.Repository.StudentEducationalRepo;
import com.profiling.profilingbackend.Repository.StudentFamilyRepo;
import com.profiling.profilingbackend.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentEducationalRepo educationalRepo;
    @Autowired
    private StudentFamilyRepo studentFamilyRepo;

    @Override
    public ResponseEntity<String> addStudent(Student student) {

        if (student == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" INVALID STUDENT DATA ");
        }

        Optional<Student> existingFirstName = studentRepo.findByFirstName(student.getFirstName());
        Optional<Student> existingLastName = studentRepo.findByLastName(student.getLastName());

        StudentEducationalBackground educationalBackground = student.getStudentEducationalBackground();
        StudentFamilyBackground familyBackground = student.getStudentFamilyBackground();

        if (existingFirstName.isPresent() && existingLastName.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(existingFirstName + " " + existingLastName + " ALREADY EXISTED");
        }
        if (educationalBackground == null || familyBackground == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" INVALID EMPTY FIELDS ");
        }
        educationalRepo.save(educationalBackground);
        studentFamilyRepo.save(familyBackground);
        studentRepo.save(student);
        return ResponseEntity.status(HttpStatus.OK).body(" ADDED NEW STUDENT ");
    }


    @Override
    public List<Student> getAllStudents() {
        if (studentRepo.findAll().isEmpty() && educationalRepo.findAll().isEmpty() && studentFamilyRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        } else {
            return studentRepo.findAll();
        }
    }

    @Override
    public Optional <Student> getStudentByID(@PathVariable String id) {
        if(studentRepo.findById(id).isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return studentRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> updateStudentByID(@PathVariable String id, @RequestBody Student updateStudent){

        Student existingStudentData = studentRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        StudentEducationalBackground existingEducationalData = educationalRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        StudentFamilyBackground existingFamilyData = studentFamilyRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));


        studentRepo.save(existingStudentData);
        educationalRepo.save(existingEducationalData);
        studentFamilyRepo.save(existingFamilyData);

        return ResponseEntity.status(HttpStatus.OK).body(" STUDENT DATA GOT UPDATED ");

    }

    @Override
    public ResponseEntity <String> deleteStudentByID(@PathVariable String id){

        Optional<StudentEducationalBackground> existingEducationalData = educationalRepo.findById(id);
        Optional<StudentFamilyBackground> existingFamilyData = studentFamilyRepo.findById(id);

        if(studentRepo.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" STUDENT ID: " + id + " DOES NOT EXIST");
        }
        studentRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(" STUDENT DATA: " + id + " HAS BEEN DELETED ");
    }
}

