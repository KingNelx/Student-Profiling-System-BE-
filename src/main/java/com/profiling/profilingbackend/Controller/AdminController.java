package com.profiling.profilingbackend.Controller;

import com.profiling.profilingbackend.Entity.Admin;
import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Service.AdminService;
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
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

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

    @GetMapping("/log-in")
    ResponseEntity <String> logInAsAdmin(@RequestParam String email, @RequestParam String userName, @RequestParam String password){
        return adminService.logInAsAdmin(email, userName, password);
    }

    // STUDENT CRUD

    @PostMapping("/add-student")
    ResponseEntity <String> addStudent(@RequestBody Student addStudent){
        return studentService.addStudent(addStudent);
    }

    @GetMapping("/get-students")
    List <Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get-student/id/{id}")
    Optional <Student> getStudentByID(@PathVariable String id){
        return studentService.getStudentByID(id);
    }

    @PutMapping("/update-student/id/{id}")
    ResponseEntity <String> updateStudentDataByID(@PathVariable String id, @RequestBody Student newData){
        return studentService.updateStudentByID(id, newData);
    }

    @DeleteMapping("/delete-student/id/{id}")
    ResponseEntity <String> deleteStudentByID(@PathVariable String id){
        return studentService.deleteStudentByID(id);
    }
}
