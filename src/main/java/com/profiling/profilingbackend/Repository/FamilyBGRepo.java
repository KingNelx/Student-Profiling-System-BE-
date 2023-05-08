package com.profiling.profilingbackend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.FamilyBG;

public interface FamilyBGRepo extends MongoRepository <FamilyBG, String>{
    
}
