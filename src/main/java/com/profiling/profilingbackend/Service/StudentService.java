package com.profiling.profilingbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profiling.profilingbackend.Model.Student;

@Service
public interface StudentService {

    // add student and others db refs
    Student registerStudent(Student registerStudent);

    // get all students
    List<Student> getAllStudents();

    // get students info by id
    Optional<Student> getStudentInfoByID(String id);

    // update students info by id
    ResponseEntity <String> udpdateStudentsInfoByID(String id, Student newStudent);

    // delete students info by id
    ResponseEntity <String> removeStudentInfoByID(String id);
}
