package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Student;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@Service
public interface StudentService {

    ResponseEntity <String> addStudent(Student student);
    List <Student> queryAllStudents();
    Optional <Student> queryStudentByID(String id);
    ResponseEntity <String> updateStudentByID(String id, Student student);
    ResponseEntity <String> deleteStudentById(String id);
}


