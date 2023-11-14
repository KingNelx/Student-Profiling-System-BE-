package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository <Student, String> {
}
