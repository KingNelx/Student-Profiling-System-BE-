package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Model.EducationalBG;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducationalBGRepo extends MongoRepository <EducationalBG, String> {
}
