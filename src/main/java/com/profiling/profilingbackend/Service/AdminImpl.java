package com.profiling.profilingbackend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.profiling.profilingbackend.Model.Admin;
import com.profiling.profilingbackend.Repository.AdminRepo;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity <String> registerAdminAccount(@RequestBody Admin newAdmin){
        Optional <Admin> existingAdminInfo = adminRepo.findByEmail();
       adminRepo.save(newAdmin);
       return ResponseEntity.ok(" ADMIN ACCOUNT REGISTED ");
    }
}
