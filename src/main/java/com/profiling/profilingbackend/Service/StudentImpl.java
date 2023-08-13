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
        StudentEducationalBackground existingEducationalData = updateStudent.getStudentEducationalBackground();
        StudentFamilyBackground existingFamilyData = updateStudent.getStudentFamilyBackground();

        if(existingEducationalData == null || existingFamilyData == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" DATA CAN NO BE EMPTY ");
        }

        existingStudentData.setFirstName(updateStudent.getFirstName());
        existingStudentData.setLastName(updateStudent.getLastName());
        existingStudentData.setGender(updateStudent.getGender());
        existingStudentData.setAge(updateStudent.getAge());

        existingEducationalData.setElementarySchool(updateStudent.getStudentEducationalBackground().getElementarySchool());
        existingEducationalData.setElementarySchoolYearStarted(updateStudent.getStudentEducationalBackground().getElementarySchoolYearStarted());
        existingEducationalData.setElementarySchoolYearEnded(updateStudent.getStudentEducationalBackground().getElementarySchoolYearEnded());
        existingEducationalData.setElementarySchoolAddress(updateStudent.getStudentEducationalBackground().getElementarySchoolAddress());

        existingEducationalData.setHighSchool(updateStudent.getStudentEducationalBackground().getHighSchool());
        existingEducationalData.setHighSchoolYearStarted(updateStudent.getStudentEducationalBackground().getHighSchoolYearStarted());
        existingEducationalData.setHighSchoolYearEnded(updateStudent.getStudentEducationalBackground().getHighSchoolYearEnded());
        existingEducationalData.setHighSchoolAddress(updateStudent.getStudentEducationalBackground().getHighSchoolAddress());

        existingEducationalData.setSeniorHighSchool(updateStudent.getStudentEducationalBackground().getSeniorHighSchool());
        existingEducationalData.setSeniorHighYearStarted(updateStudent.getStudentEducationalBackground().getSeniorHighYearStarted());
        existingEducationalData.setSeniorHighYearEnded(updateStudent.getStudentEducationalBackground().getSeniorHighYearEnded());
        existingEducationalData.setSeniorHighAddress(updateStudent.getStudentEducationalBackground().getSeniorHighAddress());

        existingEducationalData.setCollege(updateStudent.getStudentEducationalBackground().getCollege());
        existingEducationalData.setCollegeYearStarted(updateStudent.getStudentEducationalBackground().getCollegeYearStarted());
        existingEducationalData.setCollegeYearEnded(updateStudent.getStudentEducationalBackground().getCollegeYearEnded());
        existingEducationalData.setCollegeAddress(updateStudent.getStudentEducationalBackground().getCollegeAddress());

        existingFamilyData.setFathersFirstName(updateStudent.getStudentFamilyBackground().getFathersFirstName());
        existingFamilyData.setFathersLastName(updateStudent.getStudentFamilyBackground().getFathersLastName());
        existingFamilyData.setFathersAddress(updateStudent.getStudentFamilyBackground().getFathersAddress());
        existingFamilyData.setFathersCivilStatus(updateStudent.getStudentFamilyBackground().getFathersCivilStatus());
        existingFamilyData.setFathersAge(updateStudent.getStudentFamilyBackground().getFathersAge());
        existingFamilyData.setFathersContactNumber(updateStudent.getStudentFamilyBackground().getFathersContactNumber());
        existingFamilyData.setFathersOccupation(updateStudent.getStudentFamilyBackground().getFathersOccupation());
        existingFamilyData.setFathersHighestEducation(updateStudent.getStudentFamilyBackground().getFathersHighestEducation());

        existingFamilyData.setMothersFirstName(updateStudent.getStudentFamilyBackground().getMothersFirstName());
        existingFamilyData.setMothersLastName(updateStudent.getStudentFamilyBackground().getMothersLastName());
        existingFamilyData.setMothersAddress(updateStudent.getStudentFamilyBackground().getMothersAddress());
        existingFamilyData.setMothersCivilStatus(updateStudent.getStudentFamilyBackground().getMothersCivilStatus());
        existingFamilyData.setMothersAge(updateStudent.getStudentFamilyBackground().getMothersAge());
        existingFamilyData.setMothersContactNumber(updateStudent.getStudentFamilyBackground().getMothersContactNumber());
        existingFamilyData.setMothersOccupation(updateStudent.getStudentFamilyBackground().getMothersOccupation());
        existingFamilyData.setMothersHighestEducation(updateStudent.getStudentFamilyBackground().getMothersHighestEducation());


        studentRepo.save(existingStudentData);
        educationalRepo.save(existingEducationalData);
        studentFamilyRepo.save(existingFamilyData);

        return ResponseEntity.status(HttpStatus.OK).body(" STUDENT DATA GOT UPDATED ");

    }

    @Override
    public ResponseEntity <String> deleteStudentByID(@PathVariable String id){

        Optional <Student> existingData = studentRepo.findById(id);

        if(existingData.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" STUDENT DOES NOT EXIST ");
        }

        Student student = existingData.get();

        studentRepo.deleteById(id);
        educationalRepo.deleteById(student.getStudentEducationalBackground().getId());
        studentFamilyRepo.deleteById(student.getStudentFamilyBackground().getId());

        return ResponseEntity.status(HttpStatus.OK).body(" STUDENT DATA: " + id + " HAS BEEN DELETED ");
    }
}

