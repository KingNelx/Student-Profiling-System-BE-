package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Education;
import com.profiling.profilingbackend.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;


public interface StudentRepo extends MongoRepository <Student, String> {

    Optional <Student> findByStudentID(String studentID);
    List <Student> findByGender(String gender);

//    List <Education> findByEducationLevel(String educationLevel);
}
