package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Admin;
import com.profiling.profilingbackend.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-admin-account")
    public ResponseEntity <String> createAdminAccount(@RequestBody Admin admin){
        return adminService.createAdminAccount(admin);
    }

    @GetMapping("/queryAdmins")
    public List <Admin> queryAdmins(){
        return adminService.queryAllAdmins();
    }

    @GetMapping("/queryAdmin-id/{id}")
    public Optional <Admin> queryAdminByID(@PathVariable String id){
        return adminService.queryAdminByID(id);
    }
}
