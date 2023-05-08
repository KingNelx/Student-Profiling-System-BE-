package com.profiling.profilingbackend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.OtherBG;

public interface OtherBGRepo extends MongoRepository <OtherBG, String> {
    
}
