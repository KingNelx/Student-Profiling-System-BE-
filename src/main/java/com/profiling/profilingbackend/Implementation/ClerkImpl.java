package com.profiling.profilingbackend.Implementation;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Repository.ClerkRepo;
import com.profiling.profilingbackend.Service.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class ClerkImpl implements ClerkService {

    @Autowired
    private ClerkRepo clerkRepo;

    @Override
    public ResponseEntity <String> createAccount(@RequestBody Clerk clerk){
        Optional <Clerk> existingUserName();
        Optional <Clerk> existingEmail();
        try{

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
        }
    }
}
