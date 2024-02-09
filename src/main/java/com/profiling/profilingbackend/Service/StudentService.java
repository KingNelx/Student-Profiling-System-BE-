package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Student;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface StudentService {

    @Transactional
    ResponseEntity<String> addNewStudent(Student student);

    List<Student> allStudents();

    Optional<Student> queryStudentByID(String id);

    ResponseEntity<String> removeStudentData(String id);

    ResponseEntity<String> updateStudentData(Student student, String id);

    List<Student> queryAllMales();

    List<Student> queryAllFemales();

    List<Student> queryFreshman();

    List<Student> querySophomore();

    List<Student> queryJunior();

    List<Student> querySenior();

    List<Student> queryIrregular();

    Long totalStudentCount();

    Long totalMaleCount();

    Long totalFemaleCount();

}
