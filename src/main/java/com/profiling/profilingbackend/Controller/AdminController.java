package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Model.Admin;
import com.profiling.profilingbackend.Model.EducationalBG;
import com.profiling.profilingbackend.Model.FamilyBG;
import com.profiling.profilingbackend.Model.Student;
import com.profiling.profilingbackend.Service.AdminService;
import com.profiling.profilingbackend.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/createAdminAccount")
    ResponseEntity <String> registerNewAdmin(@RequestBody Admin createAdmin){
        return adminService.registerNewAdmin(createAdmin);
    }

    @GetMapping("/getAllAdmin")
    List <Admin> getAllAdmin(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/getAdminByID/{id}")
    Optional <Admin> getAdminByID(@PathVariable String id){
        return adminService.getAdminByID(id);
    }

    @PutMapping("/updateAdminData/{id}")
    ResponseEntity <String> updateAdminData(@PathVariable String id, @RequestBody Admin newAdminData){
        return adminService.updateAdminData(id, newAdminData);
    }

    @DeleteMapping("/deleteAdminData/{id}")
    ResponseEntity <String> deleteAdminData(@PathVariable String id){
        return adminService.deleteAdminData(id);
    }

    @GetMapping("/logInAsAdmin")
    ResponseEntity <String> logInAdmin(@RequestParam String userName, @RequestParam String email, @RequestParam String password){
        return adminService.logInAdmin(userName, email, password) ;
    }

    // add students
    @PostMapping("/registerStudent")
    ResponseEntity <String> registerStudents(@RequestBody Student registerStudent){
        return studentService.registerStudent(registerStudent);
    }

    @GetMapping("/getAllStudents")
    List <Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentData/{id}")
    Optional <Student> getStudentDataByID(@PathVariable String id){
        return studentService.getStudentDataByID(id);
    }


    @DeleteMapping("/deleteStudentData/{id}")
    ResponseEntity <String> removeStudentDataByID(@PathVariable String id){
        return studentService.removeStudentDataByID(id);
    }

}
