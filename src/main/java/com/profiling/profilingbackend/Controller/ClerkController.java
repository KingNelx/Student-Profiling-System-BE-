package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Model.Clerk;
import com.profiling.profilingbackend.Service.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/clerk")
public class ClerkController {

    @Autowired
    private ClerkService clerkService;

    @PostMapping("/createClerkAccount")
    ResponseEntity <String> registerNewClerk(@RequestBody Clerk registerClerk){
        return clerkService.registerNewClerk(registerClerk);
    }

    @GetMapping("/getAllClerks")
    public List <Clerk> getAllClerk(){
        return clerkService.getAllClerk();
    }

    @GetMapping("getClerk/{id}")
    Optional <Clerk> getClerkInfo(@PathVariable String id){
        return clerkService.getClerkInfo(id);
    }

    @PutMapping("/updateClerk/{id}")
    ResponseEntity <String> updateClerkInfo(@PathVariable String id, @RequestBody Clerk newClerkInfo){
        return clerkService.updateClerkInfo(id, newClerkInfo);
    }

    @DeleteMapping("/deleteClerk/{id}")
    ResponseEntity <String> deleteClerkInfo(@PathVariable String id){
        return clerkService.deleteClerkInfo(id);
    }

}
