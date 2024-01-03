package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Service.ClerkService;
import com.profiling.profilingbackend.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import java.util.Optional;
@RestController
@RequestMapping("/clerk")
@CrossOrigin(origins = "http://localhost:5173/")
public class ClerkController {

    @Autowired
    private ClerkService clerkService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAccount(@RequestBody Clerk clerk){
        return clerkService.createAccount(clerk);
    }

    @GetMapping("/queryAll")
    public List <Clerk> queryClerks(){
        return clerkService.queryClerks();
    }

    @GetMapping("/query-clerk-id/{id}")
    public Optional <Clerk> queryClerkById(@PathVariable String id){
        return clerkService.queryClerkById(id);
    }

    @PutMapping("/update-data/{id}")
    public ResponseEntity <String> updateClerkData(@PathVariable String id, @RequestBody Clerk clerk){
        return clerkService.updateClerkData(id, clerk);
    }

    @DeleteMapping("/delete-data/{id}")
    public ResponseEntity <String> deleteClerkData(@PathVariable String id){
        return clerkService.deleteClerkData(id);
    }

    @GetMapping("/sign-in")
    public ResponseEntity <String> logInAsClerk(@RequestParam String email, @RequestParam String userName, @RequestParam String password){
        return clerkService.logInAsClerk(email, userName, password);
    }

    // STUDENT
    @PostMapping("/student/add-new")
    public ResponseEntity <String> addNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @GetMapping("/student/queryAll")
    public List <Student> queryStudents(){
        return studentService.allStudents();
    }

    @GetMapping("/student/queryByID/{id}")
    public Optional <Student> queryStudentByID(@PathVariable String id){
        return studentService.queryStudentByID(id);
    }

    @DeleteMapping("/student/remove-data/{id}")
    public ResponseEntity <String> removeStudentData(@PathVariable     String id){
        return studentService.removeStudentData(id);
    }

    @PutMapping("/student/update-data/{id}")
    public ResponseEntity <String> updateStudentData(@RequestBody Student student, @PathVariable String id){
        return studentService.updateStudentData(student, id);
    }

    @GetMapping("/student/gender/males")
    public List <Student> queryMales(){
        return studentService.queryAllMales();
    }

    @GetMapping("/student/gender/females")
    public List <Student> queryFemales(){
        return studentService.queryAllFemales();
    }
}
