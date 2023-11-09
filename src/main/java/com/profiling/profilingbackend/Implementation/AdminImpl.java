package com.profiling.profilingbackend.Implementation;

import com.profiling.profilingbackend.Entity.Admin;
import com.profiling.profilingbackend.Repository.AdminRepo;
import com.profiling.profilingbackend.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity <String> adminRegister(@RequestBody Admin admin){
        Optional <Admin> existingEmail = adminRepo.findByEmail(admin.getEmail());
        Optional <Admin> existingUserName = adminRepo.findByUserName(admin.getUserName());

        try{
            if(existingEmail.isEmpty() && existingUserName.isEmpty()){
                adminRepo.save(admin);
                return ResponseEntity.status(HttpStatus.OK).body(" ADMIN ACCOUNT CREATED ");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage() + " ADMIN ALREADY EXISTED ");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG ");
    }

    @Override
    public ResponseEntity <String> adminLogIn(@RequestParam String email, @RequestParam String userName, @RequestParam String password, @RequestParam String specialCharacters){
        Admin existingAccount = adminRepo.findByEmailAndUserNameAndPasswordAndSpecialCharacters(email, userName, password, specialCharacters);
        try{
            if(existingAccount == null){
                return ResponseEntity.status(HttpStatus.OK).body(" SUCCESSFULLY LOGIN ");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage() + " ACCOUNT DOES NOT EXIST ");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG ");
    }

}
