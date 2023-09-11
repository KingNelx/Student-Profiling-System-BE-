package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Admin;
import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Services.AdminService;
import com.profiling.profilingbackend.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @Autowired
    private StudentService studentService;

    @GetMapping("/admin-login")
    public ResponseEntity <String> adminLogIn(String email, String userName, String password){
        return adminService.logInAsAdmin(email, userName, password);
    }


    @PostMapping("/ ")
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

    @PutMapping("/update-admin-id/{id}")
    public ResponseEntity <String> updateAdminData(@PathVariable String id, @RequestBody Admin updateAccount){
        return adminService.updateAdminInfo(id, updateAccount);
    }

    @DeleteMapping("/delete-admin/{id}")
    public ResponseEntity <String> deleteAdminData(@PathVariable String id){
        return adminService.deleteAdminData(id);
    }


    // STUDENT SERVICES
    @PostMapping("/add-student")
    public ResponseEntity <String> addStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @GetMapping("/query-students")
    public List <Student> queryAllStudents(){
        return studentService.queryAllStudents();
    }

    @GetMapping("/query-student/{id}")
    public Optional <Student> getStudentByID(@PathVariable String id){
        return studentService.getStudentByID(id);
    }

    @PutMapping("/update-student/{id}")
    public ResponseEntity <String> updateStudentByID(@RequestBody Student newData, @PathVariable String id){
        return studentService.updateStudentData(newData, id);
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity <String> deleteByID(@PathVariable String id){
        return studentService.deleteStudentData(id);
    }

}
