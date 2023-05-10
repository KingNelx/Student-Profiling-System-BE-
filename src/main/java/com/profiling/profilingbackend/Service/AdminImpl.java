package com.profiling.profilingbackend.Service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import com.profiling.profilingbackend.Model.Admin;
import com.profiling.profilingbackend.Repository.AdminRepo;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity<String> registerAdminAccount(@RequestBody Admin newAdmin) {
        
        Optional<Admin> existingEmailAdminInfo = adminRepo.findByEmail(newAdmin.getEmail());
        Optional<Admin> existingUserNameAdminInfo = adminRepo.findByUserName(newAdmin.getUserName());

        if (existingEmailAdminInfo.isPresent() && existingUserNameAdminInfo.isPresent()) {
            return ResponseEntity.ok(" ADMIN EMAIL AND USERNAME ALREDY EXIST ");
        }
        adminRepo.save(newAdmin);
        return ResponseEntity.ok(" ADMIN ACCOUNT REGISTED ");
    }

    @Override
    public List<Admin> getAllAdminAccount() {
        if (adminRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return adminRepo.findAll();
    }
}
