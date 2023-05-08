package com.profiling.profilingbackend.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profiling.profilingbackend.Model.Clerk;

import java.util.List;
import java.util.Optional;

@Service
public interface ClerkService {


    // add clerk
    ResponseEntity <String> addClerk(Clerk newClerk);

    // get all clerks
    List <Clerk> getAllClerks();

    // get clerk by ID
    Optional <Clerk> getClerkByID(String id);

    // edit clerk data
    ResponseEntity <String> editClerkDataByID(Clerk updateClerk, String id);

    // remove clerk by ID
    ResponseEntity <String> removeClerkDataByID(String id);

}
