package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Model.Admin;
import com.profiling.profilingbackend.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity <String> registerNewAdmin(@RequestBody Admin newAdmin){
        Optional <Admin> existingEmail = adminRepo.findByEmail(newAdmin.getEmail());
        Optional <Admin> existingUserName = adminRepo.findByUserName(newAdmin.getUserName());

        if(existingEmail.isPresent() && existingUserName.isPresent()){
        throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, " ADMIN DETAILS ALREADY REGISTERED ");
        }
        adminRepo.save(newAdmin);
        return ResponseEntity.ok(" ADMIN ACCOUNT CREATED ");
    }

    @Override
    public List <Admin> getAllAdmins(){
        if(adminRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return adminRepo.findAll();
    }

    @Override
    public Optional <Admin> getAdminByID(@PathVariable String id){
        if(!adminRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return adminRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> updateAdminData(@PathVariable String id, @RequestBody Admin newAdmin){
        Admin existingAdminInfo = adminRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingAdminInfo.setFirstName(newAdmin.getFirstName());
        existingAdminInfo.setLastName(newAdmin.getLastName());
        existingAdminInfo.setUserName(newAdmin.getUserName());
        existingAdminInfo.setEmail(newAdmin.getEmail());
        existingAdminInfo.setPassword(newAdmin.getPassword());

        adminRepo.save(existingAdminInfo);

        return ResponseEntity.ok(" ADMIN SUCCESSFULLY UPDATED ");
    }

    @Override
    public ResponseEntity <String> deleteAdminData(@PathVariable String id){
        if(!adminRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        adminRepo.deleteById(id);
        return ResponseEntity.ok(" ADMIN DATA with id: " + id + " has been DELETED ");
    }

    @Override
    public ResponseEntity <String> logInAdmin(@RequestParam String userName, @RequestParam String email, @RequestParam String password){
        Admin existingAdminInfo = adminRepo.findByEmailAndUserNameAndPassword(email, userName, password);

        if(existingAdminInfo == null){
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, " ADMIN ACCOUNT DOES NOT EXIST ");
        }
        adminRepo.findAll();
        return ResponseEntity.ok(" LOGIN SUCCESSFULLY ");
    }
}
