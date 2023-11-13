package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Clerk;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Service
public interface ClerkService {

    ResponseEntity <String> createAccount(Clerk clerk);
    ResponseEntity <String> logInAsClerk(String userName, String email, String password);
    ResponseEntity <String> updateClerkAccount(String id, Clerk clerk);
    List <Clerk> queryClerks();
    ResponseEntity <String> deleteClerksData(String id);

}
