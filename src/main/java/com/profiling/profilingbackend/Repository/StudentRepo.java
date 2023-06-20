package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface StudentRepo extends MongoRepository <Student, String> {
    List <Student> findByGender(String gender);
    List <Student> findByCourse(String course);
}
