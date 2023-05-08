package com.profiling.profilingbackend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.Dean;

public interface DeanRepo extends MongoRepository <Dean, String> {
    
}
