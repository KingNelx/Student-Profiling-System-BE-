package com.profiling.profilingbackend.Service;


import com.profiling.profilingbackend.Model.Student;
import com.profiling.profilingbackend.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public ResponseEntity <String> registerStudent(@RequestBody Student registerStudents){
        studentRepo.save(registerStudents);
        return ResponseEntity.ok(" NEW STUDENT ADDED ");
    }

    @Override
    public List <Student> getAllStudents(){
        if(studentRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return studentRepo.findAll();
    }

    @Override
    public Optional <Student> getStudentDataByID(@PathVariable String id){
        if(!studentRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return studentRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> removeStudentDataByID(@PathVariable String id){
        if(studentRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        studentRepo.deleteById(id);
        return ResponseEntity.ok(" STUDENT WITH ID: " + id + " HAS BEEN DELETED ");
    }

}
