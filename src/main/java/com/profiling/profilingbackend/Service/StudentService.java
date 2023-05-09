package com.profiling.profilingbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.profiling.profilingbackend.Model.Student;

@Service
public interface StudentService {
    

    // add students
    ResponseEntity <String> registerStudent(Student registerStudent);

    // get all students
    List <Student> getAllStudentsInfo();

    // get student info by id
    Optional <Student> getStudentsInfoById(String id);

    // update student account by id
    ResponseEntity <String> updateStudentAccount(String id, Student newStudentAccount);

}
