package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Services.ClerkService;
import com.profiling.profilingbackend.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/clerk")
@CrossOrigin(origins = "http://localhost:5173/")
public class ClerkController {

    @Autowired
    private ClerkService clerkService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createClerkAccount(@RequestBody Clerk clerk){
        return clerkService.createClerkAccount(clerk);
    }

    @GetMapping("/clerkLogIn")
    public ResponseEntity <String> clerkLogIn(@RequestParam String email, @RequestParam String userName, @RequestParam String password){
        return clerkService.clerkLogIn(email, userName, password);
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

    // STUDENT SERVICES

    @PostMapping("/add-student")
    public ResponseEntity <String> createStudents(Student newStudent){
        return studentService.addNewStudent(newStudent);
    }

    @GetMapping("/get-student")
    public List <Student> getStudents(){
        return studentService.queryAllStudents();
    }

    @GetMapping("/get-student-id/{id}")
    public Optional <Student> getStudentDataByID(@PathVariable String id){
        return studentService.getStudentByID(id);
    }
}
