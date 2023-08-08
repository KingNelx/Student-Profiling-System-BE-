package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.StudentEducationalBackground;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentEducationalRepo extends MongoRepository <StudentEducationalBackground, String> {
}
