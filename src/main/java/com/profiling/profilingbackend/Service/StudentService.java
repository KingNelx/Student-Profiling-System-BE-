package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import java.util.List;
@Service
public interface StudentService {

    // add student
    ResponseEntity <String> addStudent(Student student);

    // get all students
    List <Student> getAllStudents();

    // get student by id
    Optional <Student> getStudentByID(String id);

    // update student data
    ResponseEntity <String> updateStudentByID(String id, Student updateStudent);
    // delete student by id
    ResponseEntity <String> deleteStudentByID(String id);
}
