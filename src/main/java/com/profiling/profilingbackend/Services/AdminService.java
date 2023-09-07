package com.profiling.profilingbackend.Services;

import java.util.List;
import java.util.Optional;

import com.profiling.profilingbackend.Entity.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    // create admin account
    ResponseEntity <String> createAdminAccount(Admin createAccount);

    // get all admins
    List <Admin> queryAllAdmins();
    // get admin info by id
    Optional <Admin> queryAdminByID(String id);
    // update admin info by id

    // delete admin info by id

}
