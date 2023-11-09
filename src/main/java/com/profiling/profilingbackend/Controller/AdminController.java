package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Admin;
import com.profiling.profilingbackend.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin-register")
    public ResponseEntity <String> adminRegister(@RequestBody Admin admin){
        return adminService.adminRegister(admin);
    }

    @GetMapping("/admin-log-in")
    public ResponseEntity <String> adminLogIn(@RequestParam String email, @RequestParam String userName, @RequestParam String password, @RequestParam String specialCharacters){
        return adminService.adminLogIn(email, userName, password, specialCharacters);
    }
}
