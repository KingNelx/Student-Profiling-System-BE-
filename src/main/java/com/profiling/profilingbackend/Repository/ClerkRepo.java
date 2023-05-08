package com.profiling.profilingbackend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.Clerk;

public interface ClerkRepo extends MongoRepository <Clerk, String> {
    
}
