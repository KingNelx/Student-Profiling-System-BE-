package com.profiling.profilingbackend.Services;

import com.profiling.profilingbackend.Entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
@Service
public interface AdminService {

    ResponseEntity <String> adminRegister(Admin adminAccount);
    ResponseEntity <String> adminLogIn(String email, String userName, String password, String specialCharacters);
}
