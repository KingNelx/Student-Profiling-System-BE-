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
    private EducationRepo educationRepo;

    @Autowired
    private ParentRepo parentRepo;

    @Override
    public ResponseEntity <String> addNewStudent(@RequestBody Student addStudent){

        Student existingFirstName = studentRepo.findByFirstName(addStudent.getFirstName());
        Student existingLastName = studentRepo.findByLastName(addStudent.getLastName());

        Education existingEducation = addStudent.getEducation();
        Parents existingParent = addStudent.getParents();

        if(existingFirstName == null && existingLastName == null){
           if(existingEducation == null && existingParent == null){
               studentRepo.save(addStudent);
               return ResponseEntity.status(HttpStatus.OK).body(" NEW STUDENT ADDED ");
           }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" STUDENT ALREADY REGISTERED ");
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

}
