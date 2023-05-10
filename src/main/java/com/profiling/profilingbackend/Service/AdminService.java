package com.profiling.profilingbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    
    // register admin account
    ResponseEntity <String> registerAdminAccount();
}
