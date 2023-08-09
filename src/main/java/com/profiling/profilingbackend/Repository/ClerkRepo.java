package com.profiling.profilingbackend.Repository;

g
import com.profiling.profilingbackend.Entity.Clerk;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface ClerkRepo extends MongoRepository <Clerk, String> {
    Optional <Clerk> findByEmail(String email);
    Optional <Clerk> findByUserName(String username);
    Clerk findByEmailAndUserNameAndPassword(String email, String username, String password);
}
