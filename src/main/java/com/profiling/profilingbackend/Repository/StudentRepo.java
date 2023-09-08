package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepo extends MongoRepository <Student, String> {

    Student findByFirstName(String firstName);
    Student findByLastName(String lastName);
}
