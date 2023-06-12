package com.profiling.profilingbackend.Service;


import com.profiling.profilingbackend.Model.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public interface AdminService {

    ResponseEntity <String> registerNewAdmin(Admin createAdmin);
    List <Admin> getAllAdmins();
    Optional <Admin> getAdminByID(String id);
    ResponseEntity <String> updateAdminData(String id, Admin updatedAdminData);
    ResponseEntity <String> deleteAdminData(String id);

    ResponseEntity <String> logInAdmin(String userName, String email, String password);
}
