package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

@Service
public interface StudentService {

    // add student
    ResponseEntity <String> addStudent(Student student);
}
