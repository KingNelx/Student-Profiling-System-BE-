package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Model.Clerk;
import com.profiling.profilingbackend.Repository.ClerkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class ClerkImpl implements ClerkService {

    @Autowired
    private ClerkRepo clerkRepo;

    @Override
    public ResponseEntity<String> registerNewClerk(@RequestBody Clerk registerClerk) {
        clerkRepo.save(registerClerk);
        return ResponseEntity.ok(" CLERK ACCOUNT CREATED ");
    }

    @Override
    public List<Clerk> getAllClerk() {
        if (clerkRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return clerkRepo.findAll();
    }

    @Override
    public Optional<Clerk> getClerkInfo(String id) {
        if (clerkRepo.findById(id).isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return clerkRepo.findById(id);
    }

    @Override
    public ResponseEntity<String> updateClerkInfo(String id, Clerk updateClerk) {
        Clerk existingClerkInfo = clerkRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingClerkInfo.setFirstName(updateClerk.getFirstName());
        existingClerkInfo.setLastName(updateClerk.getLastName());
        existingClerkInfo.setUserName(updateClerk.getUserName());
        existingClerkInfo.setEmail(updateClerk.getEmail());
        existingClerkInfo.setPassword(updateClerk.getPassword());
        clerkRepo.save(existingClerkInfo);
        return ResponseEntity.ok(" CLERK UPDATED SUCCESSFULLY ");
    }

    @Override
    public ResponseEntity<String> deleteClerkInfo(@PathVariable String id) {
        if (clerkRepo.findById(id).isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        clerkRepo.deleteById(id);
        return ResponseEntity.ok(" DATA ID: " + id + " HAS BEEN DELETED ");
    }

    @Override
    public ResponseEntity <String> logInClerk(@RequestParam String userName, @RequestParam String email, @RequestParam String password){
        Clerk existingClerkInfo = clerkRepo.findByEmailAndUserNameAndPassword(userName, email, password);

        if(existingClerkInfo == null){
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(" LOGIN SUCCESSFULLY ");
    }
}