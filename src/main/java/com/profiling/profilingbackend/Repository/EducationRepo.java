package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Education;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface EducationRepo extends MongoRepository <Education, String> {

    List <Education> findByEducationLevel(String educationLevel);
}
