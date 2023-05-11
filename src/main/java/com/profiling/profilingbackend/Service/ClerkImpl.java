package com.profiling.profilingbackend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.profiling.profilingbackend.Model.Clerk;
import com.profiling.profilingbackend.Repository.ClerkRepo;

@Service
public class ClerkImpl implements ClerkService {

    @Autowired
    private ClerkRepo clerkRepo;

    @Override
    public ResponseEntity<String> registerClerk(@RequestBody Clerk newClerk) {
        Optional<Clerk> existingEmailInfo = clerkRepo.findByEmail(newClerk.getEmail());
        Optional<Clerk> existingUserNameInfo = clerkRepo.findByUserName(newClerk.getUserName());

        if (existingEmailInfo.isPresent() && existingUserNameInfo.isPresent()) {
            return ResponseEntity.ok(" CLERK EMAIL AND USERNAME ALREADY EXIST ");
        }
        return ResponseEntity.ok(" CLERK ACCOUNT CREATED ");
    }
}
