package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Repository.ClerkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ClerkImpl implements  ClerkService {

    @Autowired
    private ClerkRepo clerkRepo;

    @Override
    public ResponseEntity <String> createClerk(@RequestBody Clerk createClerk){
        Optional <Clerk> existingEmail = clerkRepo.findByEmail(createClerk.getEmail());
        Optional <Clerk> existingUsername = clerkRepo.findByUserName(createClerk.getUserName());

        if(existingEmail.isPresent() || existingUsername.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" EMAIL AND USERNAME ALREADY EXISTED ");
        }
        clerkRepo.save(createClerk);
        return ResponseEntity.status(HttpStatus.OK).body(" CLERK ACCOUNT CREATED ");
    }

    @Override
    public List <Clerk> getAllClerks(){
        if(clerkRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }else{
            return clerkRepo.findAll();
        }
    }

    @Override
    public Optional <Clerk> getClerkByID(@PathVariable String id){
        if(clerkRepo.findById(id).isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }else{
            return clerkRepo.findById(id);
        }
    }

    @Override
    public ResponseEntity <String> updateClerkByID(@PathVariable String id, @RequestBody Clerk newClerkData){
        Clerk existingClerk = clerkRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        existingClerk.setFirstName(newClerkData.getFirstName());
        existingClerk.setLastName(newClerkData.getLastName());
        existingClerk.setEmail(newClerkData.getEmail());
        existingClerk.setUserName(newClerkData.getUserName());
        existingClerk.setPassword(newClerkData.getPassword());

        clerkRepo.save(existingClerk);

        return ResponseEntity.status(HttpStatus.OK).body(" CLERK DATA UPDATED SUCCESSFULLY ");
    }

    @Override
    public ResponseEntity <String> deleteClerkByData(@PathVariable String id){
        if(clerkRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(" CLERK DATA HAS BEEN DELETED ");
        }
    }
}
