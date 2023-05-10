package com.profiling.profilingbackend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.PersonalBG;

public interface PersonalBGRepo extends MongoRepository <PersonalBG, String>{
    
}
