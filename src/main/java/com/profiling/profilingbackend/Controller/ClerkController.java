package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Service.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clerk")
public class ClerkController {

    @Autowired
    private ClerkService clerkService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAccount(@RequestBody Clerk clerk){
       return clerkService.createAccount(clerk);
    }

    @GetMapping("/sign-in")
    public ResponseEntity <String> logInAsClerk(@RequestParam String userName, @RequestParam String email, @RequestParam String password){
        return clerkService.logInAsClerk(userName, email, password);
    }

    @PutMapping("/update-account/{id}")
    public ResponseEntity <String> updateClerkAccount(@PathVariable String id, @RequestBody Clerk clerk){
        return clerkService.updateClerkAccount(id, clerk);
    }

    @GetMapping("/queryAll")
    public List <Clerk> queryClerks(){
        return clerkService.queryClerks();
    }

    @DeleteMapping("/delete-data/{id}")
    public ResponseEntity <String> deleteClerkData(@PathVariable String id){
        return clerkService.deleteClerksData(id);
    }

}
