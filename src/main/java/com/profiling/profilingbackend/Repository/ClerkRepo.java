package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Clerk;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ClerkRepo extends MongoRepository <Clerk, String> {

    Optional <Clerk> findByUserName(String userName);
    Optional <Clerk> findByEmail(String email);
    Clerk findByEmailAndUserNameAndPassword(String email, String userName, String password);
}
