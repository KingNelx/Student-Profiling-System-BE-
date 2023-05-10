package com.profiling.profilingbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profiling.profilingbackend.Model.Admin;

@Service
public interface AdminService {
    
    // register admin account
    ResponseEntity <String> registerAdminAccount(Admin registerAdmin);
}
