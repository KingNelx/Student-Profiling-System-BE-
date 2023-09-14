package com.profiling.profilingbackend.Services;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Repository.ClerkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class ClerkImpl implements ClerkService{

    @Autowired
    private ClerkRepo clerkRepo;

    @Override
    public ResponseEntity <String> createClerkAccount(@RequestBody Clerk clerk){
        Optional <Clerk> existingEmail = clerkRepo.findByEmail(clerk.getEmail());
        Optional <Clerk> existingLastName = clerkRepo.findByLastName(clerk.getLastName());

        try{
            if(existingEmail.isEmpty() && existingLastName.isEmpty()){
                clerkRepo.save(clerk);
                return ResponseEntity.status(HttpStatus.OK).body(" CLERK ACCOUNT CREATED ");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" CLERK ACCOUNT ALREADY EXISTED ");
    }

    @Override
    public ResponseEntity <String> clerkLogIn(@RequestParam String email, @RequestParam String userName, @RequestParam String password){
       try{
           Clerk existingAccount = clerkRepo.findByEmailAndUserNameAndPassword(email, userName, password);
           if(existingAccount != null){
               return ResponseEntity.status(HttpStatus.OK).body(" CLERK LOGGED IN SUCCESSFULLY ");
           }
       }catch(Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" CLERK DATA NOT FOUND ");
    }

    @Override
    public List <Clerk> getAllClerks(){
        try{
            if(!clerkRepo.findAll().isEmpty()){
                return clerkRepo.findAll();
            }
        }catch (Exception e){
          throw new RuntimeException(e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional <Clerk> getClerkDataByID(@PathVariable String id){
        try{
            if(clerkRepo.findById(id).isPresent()){
                return clerkRepo.findById(id);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity <String> updateClerk(@RequestBody Clerk newClerk, @PathVariable String id){
        Clerk existingInfo = clerkRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        existingInfo.setFirstName(newClerk.getFirstName());
        existingInfo.setLastName(newClerk.getLastName());
        existingInfo.setEmail(newClerk.getEmail());
        existingInfo.setUserName(newClerk.getUserName());
        existingInfo.setPassword(newClerk.getPassword());

        clerkRepo.save(existingInfo);
        return ResponseEntity.status(HttpStatus.OK).body(" CLERK DATA UPDATED ");
    }

    @Override
    public ResponseEntity <String> deleteClerkData(@PathVariable String id){
        try{
            if(clerkRepo.findById(id).isPresent()){
                clerkRepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body(" CLERK DATA HAS BEEN DELETED ");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" CLERK DATA NOT FOUND ");
    }
}
