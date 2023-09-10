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

        Education education = addStudent.getEducation();
        Parents parents = addStudent.getParents();

        Optional <Student> existingID = studentRepo.findByStudentID(addStudent.getStudentID());

        if(existingID.isPresent()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("STUDENT DATA ALREADY EXISTED ");
        }

        studentRepo.save(addStudent);
        educationRepo.save(education);
        parentRepo.save(parents);

        return ResponseEntity.status(HttpStatus.OK).body(" NEW STUDENT ADDED ");
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
