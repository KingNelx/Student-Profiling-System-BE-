package com.profiling.profilingbackend.Services;

import java.util.List;
import java.util.Optional;

import com.profiling.profilingbackend.Entity.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    // create admin account
    ResponseEntity <String> createAdminAccount(Admin createAccount);

}
