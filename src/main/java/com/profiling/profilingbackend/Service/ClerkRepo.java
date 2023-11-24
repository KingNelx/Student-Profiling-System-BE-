package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Clerk;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
@Service
public interface ClerkRepo {

    ResponseEntity <String> createAccount(Clerk createAccount);
    List <Clerk> queryClerks();
    Optional <Clerk> queryClerkById(String id);
    ResponseEntity <String> updateClerkData(String id, Clerk updateData);
    ResponseEntity <String> deleteClerkData(String id);

}
