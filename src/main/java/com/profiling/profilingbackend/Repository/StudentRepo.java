package com.profiling.profilingbackend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.Student;

public interface StudentRepo extends MongoRepository <Student, String> {
    
}
