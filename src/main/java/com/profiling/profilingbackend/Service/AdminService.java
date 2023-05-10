package com.profiling.profilingbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profiling.profilingbackend.Model.Admin;

@Service
public interface AdminService {
    
    // register admin account
    ResponseEntity <String> registerAdminAccount(Admin registerAdmin);

    // log in admin account
    ResponseEntity <String> logInAdmin(String userName, String password);

    // get all admin acoounts
    List <Admin> getAllAdminAccount();

    // get admin by id
    Optional <Admin> getAdminInfoByID(String id);

    // update admin info by id
    ResponseEntity <String> updateAdminInfoByID(String id, Admin newAdminInfo);

    // remove admins data by id
    ResponseEntity <String> removeAdminsDataByID(String id);

}
