package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@Service
public class StudentImpl extends StudentService{

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public ResponseEntity <String> addStudent(Student student){
        Optional <Student> existingFirstName = studentRepo.findByFirstName(student.getFirstName());
        Optional <Student> existingLastName = studentRepo.findByLastName(student.getLastName());

    }
}
