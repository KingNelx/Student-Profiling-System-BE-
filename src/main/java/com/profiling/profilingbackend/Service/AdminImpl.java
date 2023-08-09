package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Admin;
import com.profiling.profilingbackend.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
@Service
public class AdminImpl implements AdminService{

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity <String> createAdmin(@RequestBody Admin createAdmin) {
        Optional <Admin> existingEmail = adminRepo.findByEmail(createAdmin.getEmail());
        Optional <Admin> existingUsername = adminRepo.findByUserName(createAdmin.getUserName());

        if(existingEmail.isPresent() || existingUsername.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" EMAIL AND USERNAME ALREADY EXISTED ");
        }
        adminRepo.save(createAdmin);
        return ResponseEntity.status(HttpStatus.OK).body(" ADMIN ACCOUNT CREATED ");
    }

    @Override
    public List <Admin> getAdmin(){
        if(adminRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return adminRepo.findAll();
    }

    @Override
    public Optional <Admin> getAdminByID(@PathVariable String id) {

        if(!adminRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return adminRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> updateAdminDataByID(@PathVariable String id, @RequestBody Admin newAdminData){
        Admin existingAdmin = adminRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingAdmin.setFirstName(newAdminData.getFirstName());
        existingAdmin.setLastName(newAdminData.getLastName());
        existingAdmin.setEmail(newAdminData.getEmail());
        existingAdmin.setUserName(newAdminData.getUserName());
        existingAdmin.setPassword(newAdminData.getPassword());

        adminRepo.save(existingAdmin);

        return ResponseEntity.status(HttpStatus.OK).body(" ADMIN DATA UPDATED SUCCESSFULLY ");
    }

    @Override
    public ResponseEntity <String> deleteAdminByID(@PathVariable String id){
        if(!adminRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        adminRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(" ADMIN DATA HAS BEEN DELETED ");
    }
}
