package com.profiling.profilingbackend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.Admin;

public interface AdminRepo extends MongoRepository <Admin, String> {
    
}
