package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Clerk;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ClerkRepo {

    Optional <Clerk> findByUserName(String userName);
    Optional <Clerk> findByEmail(String email);
    Optional <Clerk> findByPassword(String password);
    Optional <Clerk> findByConfirmPassword(String confirmPassword);
}
