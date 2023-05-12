package com.profiling.profilingbackend.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profiling.profilingbackend.Model.Clerk;

public interface ClerkRepo extends MongoRepository <Clerk, String>{
    Optional <Clerk> findByEmail(String email);
    Optional <Clerk> findByUserName(String userName);
    Clerk findByUserNameAndPassword(String userName, String password);
}
