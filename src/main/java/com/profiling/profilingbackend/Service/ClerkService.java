package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Clerk;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import org.springframework.http.ResponseEntity;
@Service
public interface ClerkService {

    // create clerk
    ResponseEntity <String> createClerk(Clerk createClerk);

    // get all clerks
    List <Clerk> getAllClerks();

    // get clerk by id
    Optional <Clerk> getClerkByID(String id);

    // update clerk by id
    ResponseEntity <String> updateClerkByID(String id, Clerk newClerkData);

    // delete clerk by id
    ResponseEntity <String> deleteClerkByData(String id);
}
