package com.profiling.profilingbackend.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.profiling.profilingbackend.Model.Clerk;
import java.util.List;
import java.util.Optional;

@Service
public interface ClerkService {
    
    // register clerk
    ResponseEntity <String> registerClerk(Clerk registerClerk);

    // get all clerks account
    List <Clerk> getAllClerksAccount();

}
