package com.profiling.profilingbackend.Services;


import com.profiling.profilingbackend.Entity.Education;
import com.profiling.profilingbackend.Entity.Parents;
import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Repository.EducationRepo;
import com.profiling.profilingbackend.Repository.ParentRepo;
import com.profiling.profilingbackend.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.security.interfaces.RSAPrivateCrtKey;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private EducationRepo educationRepo;

    @Autowired
    private ParentRepo parentRepo;

    @Transactional
    @Override
    public ResponseEntity <String> addNewStudent(@RequestBody Student student) {

        Education education = student.getEducation();
        Parents parents = student.getParents();
        Optional <Student> existingID = studentRepo.findByStudentID(student.getStudentID());

        if(existingID.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" CURRENT DATA ALREADY SAVED ");
        }
        try{
            if(education == null || education.getId() == null || parents == null || parents.getId() == null){
                educationRepo.save(education);
                parentRepo.save(parents);
                studentRepo.save(student);
                return ResponseEntity.status(HttpStatus.OK).body(" NEW STUDENT ADDED ");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

        @Override
    public List <Student> queryAllStudents(){
        if(studentRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findAll();
    }

    @Override
    public Optional <Student> getStudentByID(@PathVariable String id){
        if(studentRepo.findById(id).isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return studentRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> deleteStudentData(@PathVariable String id){

        Optional <Student> studentDataHandler = studentRepo.findById(id);

        if(studentDataHandler.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" DATA DOES NOT EXIST ");
        }

        Student studentHandler = studentDataHandler.get();
        studentRepo.deleteById(id);
        educationRepo.deleteById(studentHandler.getEducation().getId());
        parentRepo.deleteById(studentHandler.getParents().getId());

        return ResponseEntity.status(HttpStatus.OK).body(" STUDENT DATA HAS BEEN DELETED ");
    }
}
