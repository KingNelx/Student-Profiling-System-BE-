package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface AdminRepo extends MongoRepository <Admin, String> {

    Optional <Admin> findByEmail(String email);
    Optional <Admin> findByUsername(String username);

}
