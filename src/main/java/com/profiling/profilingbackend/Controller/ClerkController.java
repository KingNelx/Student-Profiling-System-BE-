package com.profiling.profilingbackend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profiling.profilingbackend.Model.Clerk;
import com.profiling.profilingbackend.Service.ClerkService;

@RestController
@RequestMapping ("api/clerk")
public class ClerkController {
    
    @Autowired
    private ClerkService clerkService;

    @PostMapping ("/createNewClerk")
    public ResponseEntity <String> createNewClerk(@RequestBody Clerk newClerk){
        return clerkService.addClerk(newClerk);
    }

    @GetMapping("/getAllClerk")
    public List <Clerk> getAllClerks(){
        return clerkService.getAllClerks();
    }

    @GetMapping("/getClerkByID/{id}")
    public Optional <Clerk> getClerkByID(@PathVariable String id){
        return clerkService.getClerkByID(id);
    }

    @PutMapping("/editClerkDataByID/{id}")
    public ResponseEntity <String> editClerkDataByID(@RequestBody Clerk newData, @PathVariable String id){
        return clerkService.editClerkDataByID(newData, id);
    }

    @DeleteMapping ("/deleteClerkDataByID/{id}")
    public ResponseEntity <String> removeClerkByData(@PathVariable String id){
        return clerkService.removeClerkDataByID(id);
    }



}
