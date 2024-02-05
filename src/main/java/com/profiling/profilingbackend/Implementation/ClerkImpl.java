package com.profiling.profilingbackend.Implementation;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Repository.ClerkRepo;
import com.profiling.profilingbackend.Service.ClerkService;
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
    public ResponseEntity<String> createAccount(@RequestBody Clerk clerk) {
        Optional<Clerk> existingUserName = clerkRepo.findByUserName(clerk.getUserName());
        Optional<Clerk> existingEmail = clerkRepo.findByEmail(clerk.getEmail());

        try {
            if (existingUserName.isEmpty() && existingEmail.isEmpty()) {
                clerkRepo.save(clerk);
                return ResponseEntity.status(HttpStatus.OK).body(" ACCOUNT CREATED ");
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(" ACCOUNT ALREADY EXISTED ");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(" SOMETHING WENT WRONG " + e.getMessage());
        }
    }

    @Override
    public List<Clerk> queryClerks() {
        List<Clerk> allClerks = clerkRepo.findAll();
        try {
            if (!allClerks.isEmpty()) {
                return clerkRepo.findAll();
            } else {
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    " SOMETHING WENT WRONG " + e.getMessage());
        }
    }

    @Override
    public Optional<Clerk> queryClerkById(@PathVariable String id) {
        Optional<Clerk> clerkID = clerkRepo.findById(id);
        try {
            if (clerkID.isPresent()) {
                return clerkRepo.findById(id);
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage() + " SOMETHING WENT WRONG ");
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> updateClerkData(@PathVariable String id, @RequestBody Clerk clerk) {
        Clerk existingAccount = clerkRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        if (clerk == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ENTITY MUST NOT BE NULL ");
        }
        try {
            if (existingAccount != null) {
                existingAccount.setEmail(clerk.getEmail());
                existingAccount.setUserName(clerk.getUserName());
                existingAccount.setPassword(clerk.getPassword());
                existingAccount.setConfirmPassword(clerk.getConfirmPassword());
                clerkRepo.save(existingAccount);
                return ResponseEntity.status(HttpStatus.OK).body(" ACCOUNT UPDATED SUCCESSFULLY ");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" DATA DOES NOT EXIST ");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(" SOMETHING WENT WRONG " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> deleteClerkData(@PathVariable String id) {
        try {
            if (clerkRepo.findById(id).isPresent()) {
                clerkRepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body(" CLERK DATA DELETED ");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" DATA DOES NOT EXIST ");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(" SOMETHING WENT WRONG " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> logInAsClerk(@RequestParam String email, @RequestParam String userName,
            @RequestParam String password) {
        Clerk existingAccount = clerkRepo.findByEmailAndUserNameAndPassword(email, userName, password);
        try {
            if (existingAccount != null) {
                return ResponseEntity.status(HttpStatus.OK).body(" SUCCESSFULLY LOG IN ");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" ACCOUNT DOES NOT EXIST ");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(" SOMETHING WENT WRONG " + e.getCause());
        }
    }


}
