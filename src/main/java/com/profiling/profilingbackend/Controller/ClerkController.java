package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Services.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/clerk")
public class ClerkController {

    @Autowired
    private ClerkService clerkService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createClerkAccount(@RequestBody Clerk clerk){
        return clerkService.createClerkAccount(clerk);
    }

    @GetMapping("/query-clerks")
    public List <Clerk> getAllClerks(){
        return clerkService.getAllClerks();
    }

    @GetMapping("/query-clerk-id/{id}")
    public Optional <Clerk> getClerkDataByID(@PathVariable String id){
        return clerkService.getClerkDataByID(id);
    }

    @PutMapping("/update-clerk-id/{id}")
    public ResponseEntity <String> updateClerk(@RequestBody Clerk clerk, @PathVariable String id){
        return clerkService.updateClerk(clerk,id);
    }


    @DeleteMapping("/delete-clerk-id/{id}")
    public ResponseEntity <String> deleteClerkData(@PathVariable String id){
        return clerkService.deleteClerkData(id);
    }

}
