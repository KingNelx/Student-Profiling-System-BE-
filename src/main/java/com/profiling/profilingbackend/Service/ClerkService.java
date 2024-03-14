package com.profiling.profilingbackend.Service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.profiling.profilingbackend.Entity.Clerk;

import org.springframework.http.ResponseEntity;

@Service
public interface ClerkService {

    ResponseEntity<String> createAccount();

    ResponseEntity<String> logInAsClerk(String firstName, String lastName, String emailAddress, String role,
            String userName, String password);

    Optional<Clerk> findClerkByID(Long id);
}
