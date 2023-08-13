package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Repository.ClerkRepo;
import com.profiling.profilingbackend.Service.ClerkService;
import com.profiling.profilingbackend.Service.StudentService;
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

    @Autowired
    private StudentService studentService;

    @PostMapping("/create-account")
    ResponseEntity <String> createAccount(@RequestBody Clerk createAccount){
        return clerkService.createClerk(createAccount);
    }

    @GetMapping("/get-clerks")
    List <Clerk> getAllClerks(){
        return clerkService.getAllClerks();
    }

    @GetMapping("/get-clerk-id/{id}")
    Optional <Clerk> getClerkByID(@PathVariable String id){
        return clerkService.getClerkByID(id);
    }

    @PutMapping("/update-clerk-id/{id}")
    ResponseEntity <String> updateClerkByID(@PathVariable String id, @RequestBody Clerk updateClerkData){
        return clerkService.updateClerkByID(id, updateClerkData);
    }

    @DeleteMapping("/delete-clerk-id/{id}")
    ResponseEntity <String> deleteClerkByID(@PathVariable String id){
        return clerkService.deleteClerkByData(id);
    }

    @GetMapping("/log-in")
    ResponseEntity <String> logInAsClerk(@RequestParam String email, @RequestParam String userName, @RequestParam String password){
        return clerkService.logInAsClerk(email, userName, password);
    }

    // view students only
    @GetMapping("/get-students")
    List <Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get-student-id/{id}")
    Optional <Student> getStudentByID(@PathVariable String id){
        return studentService.getStudentByID(id);
    }
}
