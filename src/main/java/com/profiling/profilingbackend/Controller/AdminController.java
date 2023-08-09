package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Admin;
import com.profiling.profilingbackend.Service.AdminService;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAdminAccount(@RequestBody Admin createAdmin){
        return adminService.createAdmin(createAdmin);
    }

    @GetMapping("/get-admins")
    public List <Admin> getAdmins(){
        return adminService.getAdmin();
    }

    @GetMapping("/get-admin-id/{id}")
    Optional <Admin> getAdminByID(@PathVariable String id){
        return adminService.getAdminByID(id);
    }

    @PutMapping("/update-admin-id/{id}")
    ResponseEntity <String> updateAdminDataByID(@PathVariable String id, @RequestBody Admin newAdminData){
        return adminService.updateAdminDataByID(id, newAdminData);
    }

    @DeleteMapping("/delete-admin-id/{id}")
    ResponseEntity <String> deleteAdminByID(@PathVariable String id){
        return adminService.deleteAdminByID(id);
    }
}
