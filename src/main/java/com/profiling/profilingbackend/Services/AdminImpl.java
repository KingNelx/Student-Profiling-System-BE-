package com.profiling.profilingbackend.Services;

import com.profiling.profilingbackend.Entity.Admin;
import com.profiling.profilingbackend.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity <String> createAdminAccount(@RequestBody Admin createAccount){
        Optional <Admin> existingEmail = adminRepo.findByEmail(createAccount.getEmail());
        Optional <Admin> existingLastName = adminRepo.findByLastName(createAccount.getLastName());

       if(existingEmail.isEmpty() || existingLastName.isEmpty()){
           adminRepo.save(createAccount);
           return ResponseEntity.status(HttpStatus.OK).body(" ADMIN ACCOUNT CREATED ");
       }

       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ADMIN ACCOUNT ALREADY EXISTED");
    }

    @Override
    public List <Admin> queryAllAdmins(){
        if(adminRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return adminRepo.findAll();
    }

    @Override
    public Optional <Admin> queryAdminByID(@PathVariable String id){
        boolean doesExist = adminRepo.findById(id).isPresent();

        if(!doesExist){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return adminRepo.findById(id);
    }



}
