package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Model.EducationalBG;
import com.profiling.profilingbackend.Model.FamilyBG;
import com.profiling.profilingbackend.Model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public interface StudentService {

    ResponseEntity <String> registerStudent(Student registerStudent);
    List <Student> getAllStudents();
    Optional <Student> getStudentDataByID(String id);
    ResponseEntity <String> removeStudentDataByID(String id);
    ResponseEntity <String> updateStudentData(Student updateData, String id);
    List <Student> findAllMales();
    List <Student> findAllFemales();
    List <Student> findAllBSIT();
    List <Student> findAllBSIS();
    List <Student> findAllBSCS();
}
