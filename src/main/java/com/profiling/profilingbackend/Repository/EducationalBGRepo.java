package com.profiling.profilingbackend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.EducationalBG;

public interface EducationalBGRepo extends MongoRepository <EducationalBG, String> {
    
}
