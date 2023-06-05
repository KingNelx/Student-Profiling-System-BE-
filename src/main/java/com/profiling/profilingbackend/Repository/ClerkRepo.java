package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Model.Clerk;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClerkRepo extends MongoRepository <Clerk, String> {

}
