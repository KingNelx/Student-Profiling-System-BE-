package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Education;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducationRepo extends MongoRepository <Education, String> {
}
