package com.profiling.profilingbackend.Service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
        return ResponseEntity.ok(" ADMIN ACCOUNT CREATED ");
    }

    @Override
    public ResponseEntity<String> logInAdmin(@RequestParam String userName, @RequestParam String password) {
        Admin adminInfo = adminRepo.findByUserNameAndPassword(userName, password);
        if (adminInfo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(" INVALID USERNAME OR PASSWORD ");
        }
        return ResponseEntity.ok(" Login Successful! ");
    }

    @Override
    public List<Admin> getAllAdminAccount() {
        if (adminRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return adminRepo.findAll();
    }

    @Override
    public Optional<Admin> getAdminInfoByID(@PathVariable String id) {
        if (adminRepo.findById(id).isPresent()) {
            return adminRepo.findById(id);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> updateAdminInfoByID(@PathVariable String id, @RequestBody Admin newAdminsData) {
        Admin existingInfo = adminRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingInfo.setFirstName(newAdminsData.getFirstName());
        existingInfo.setLastName(newAdminsData.getLastName());
        existingInfo.setEmail(newAdminsData.getEmail());
        existingInfo.setUserName(newAdminsData.getUserName());
        existingInfo.setPassword(newAdminsData.getPassword());
        adminRepo.save(existingInfo);

        return ResponseEntity.ok(" ADMINS DATA UPDATED ");
    }

    @Override
    public ResponseEntity<String> removeAdminsDataByID(@PathVariable String id) {
        if (!adminRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        adminRepo.deleteById(id);
        return ResponseEntity.ok(" ADMIN with id: " + id + " got DELETED");
    }

}
