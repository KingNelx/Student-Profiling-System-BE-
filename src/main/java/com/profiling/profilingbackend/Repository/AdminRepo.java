package com.profiling.profilingbackend.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.Admin;

public interface AdminRepo extends MongoRepository <Admin, String> {
    Optional <Admin> findByEmail(String email);
    Optional <Admin> findByUserName(String userName);
}
