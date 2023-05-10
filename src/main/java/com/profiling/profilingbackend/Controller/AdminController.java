package com.profiling.profilingbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.profiling.profilingbackend.Model.Admin;
import com.profiling.profilingbackend.Service.AdminService;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @PostMapping ("/registerAdmin")
    public ResponseEntity <String> registerAdmin(@RequestBody Admin newAdmin){
        return adminService.registerAdminAccount(newAdmin);
    }

    @GetMapping("/loginAdmin")
    public ResponseEntity <String> logInAdmin(@RequestParam String userName, @RequestParam String password){
        return adminService.logInAdmin(userName, password);
    }

    @GetMapping("/getAllAdmins")
    public List <Admin> getAllAdmins(){
        return adminService.getAllAdminAccount();
    }
}
