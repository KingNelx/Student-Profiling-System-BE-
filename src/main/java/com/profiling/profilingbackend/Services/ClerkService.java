package com.profiling.profilingbackend.Services;

import com.profiling.profilingbackend.Entity.Clerk;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
@Service

public interface ClerkService {

    ResponseEntity <String> createClerkAccount(Clerk clerk);

    List <Clerk> getAllClerks();

    Optional <Clerk> getClerkDataByID(String id);

    ResponseEntity <String> updateClerk(Clerk newData, String id);

    ResponseEntity <String> deleteClerkData(String id);

    ResponseEntity <String> clerkLogIn(String email, String userName, String password);
}
