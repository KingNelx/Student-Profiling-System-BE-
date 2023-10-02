package com.profiling.profilingbackend.Services;

import com.profiling.profilingbackend.Entity.Education;
import com.profiling.profilingbackend.Entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {

    ResponseEntity <String> addNewStudent(Student newStudent);

    List <Student> queryAllStudents();

    Optional <Student> getStudentByID(String id);

    ResponseEntity <String> updateStudentData(String id, Student newData);
    ResponseEntity <String> deleteStudentData(String id);

    List <Student> fetchAllMales();
    List <Student> fetchAllFemales();

//    List <Education> fetchAllElementary();
}
