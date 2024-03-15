package com.profiling.profilingbackend.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Service.ClerkService;

@RestController
@RequestMapping("/clerk")
public class ClerkController {

    @Autowired
    private ClerkService clerkService;

    @PostMapping("/account/sign-up")
    public ResponseEntity<String> createAccount(@RequestBody Clerk clerk) {
        return clerkService.createAccount(clerk);
    }

    @GetMapping("/account/sign-in")
    public ResponseEntity<String> logInAsClerk(@RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String emailAddress, @RequestParam String role, @RequestParam String userName,
            @RequestParam String password) {
        return clerkService.logInAsClerk(firstName, lastName, emailAddress, role, userName, password);
    }

    @GetMapping("/info/get-id/{id}")
    public Optional<Clerk> getInfoById(@PathVariable Long id) {
        return clerkService.findClerkByID(id);
    }
}
