package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Model.Clerk;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface ClerkRepo extends MongoRepository <Clerk, String> {
    Optional <Clerk> findByEmail(String email);
    Optional <Clerk> findByUserName(String userName);
    Clerk findByEmailAndUserNameAndPassword(String email, String userName, String password);
}
