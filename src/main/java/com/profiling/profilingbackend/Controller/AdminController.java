package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Model.Admin;
import com.profiling.profilingbackend.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

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
        return adminService.logInAdmin(userName, email, password) ;g
    }
}
