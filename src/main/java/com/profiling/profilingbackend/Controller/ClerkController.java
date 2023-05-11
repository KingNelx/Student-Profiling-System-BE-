package com.profiling.profilingbackend.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profiling.profilingbackend.Model.Clerk;
import com.profiling.profilingbackend.Service.ClerkService;

@RestController
@RequestMapping("/api/clerk")
public class ClerkController {
    
    @Autowired
    private ClerkService clerkService;

    @PostMapping ("/registerClerk")
    public ResponseEntity <String> registerClerk(@RequestBody Clerk newClerk){
        return clerkService.registerClerk(newClerk);
    }

    @GetMapping ("/getAllClerks")
    public List <Clerk> getAllClerks(){
        return clerkService.getAllClerksAccount();
    }
}