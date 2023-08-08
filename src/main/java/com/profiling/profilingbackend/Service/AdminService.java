package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {

    // create admin
    ResponseEntity <String> createAdmin(Admin createAdmin);

    // get admin
    List <Admin> getAdmin();

    // get admin by id
    Optional <Admin> getAdminByID(String id);

    // update admin by id
    ResponseEntity <String> updateAdminDataByID(String id, Admin newAdminData);

    // delete admin by id
    ResponseEntity <String> deleteAdminByID(String id);
}
