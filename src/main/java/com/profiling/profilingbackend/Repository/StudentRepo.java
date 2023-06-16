package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository <Student, String> {
}
