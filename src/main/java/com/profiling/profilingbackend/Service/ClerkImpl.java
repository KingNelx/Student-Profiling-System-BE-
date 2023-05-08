package com.profiling.profilingbackend.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.profiling.profilingbackend.Model.Clerk;
import com.profiling.profilingbackend.Repository.ClerkRepo;

@Service
public class ClerkImpl implements ClerkService {

    @Autowired
    private ClerkRepo clerkRepo;

    @Override
    public ResponseEntity<String> addClerk(Clerk newClerk) {
        clerkRepo.save(newClerk);
        return ResponseEntity.ok(" CREATED NEW CLERK ");
    }

    @Override
    public List<Clerk> getAllClerks() {
        if (clerkRepo.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return clerkRepo.findAll();
    }

    @Override
    public Optional<Clerk> getClerkByID(String id) {
        if (!clerkRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return clerkRepo.findById(id);
    }

    @Override
    public ResponseEntity<String> editClerkDataByID(Clerk newClerkData, String id) {
        Clerk existingData = clerkRepo.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        existingData.setFirstName(newClerkData.getFirstName());
        existingData.setLastName(newClerkData.getLastName());
        existingData.setEmail(newClerkData.getEmail());
        existingData.setUserName(newClerkData.getUserName());
        existingData.setPassword(newClerkData.getPassword());
        clerkRepo.save(existingData);
        return ResponseEntity.ok("CLERK DATA UPDATED");
    }

    @Override
    public ResponseEntity<String> removeClerkDataByID(String id) {
        if (!clerkRepo.findById(id).isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(" CLERK DATA DELETED ");
    }

}
