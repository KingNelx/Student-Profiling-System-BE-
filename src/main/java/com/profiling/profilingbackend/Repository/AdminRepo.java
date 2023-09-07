package com.profiling.profilingbackend.Repository;

import java.util.Optional;
import com.profiling.profilingbackend.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepo extends MongoRepository <Admin, String> {

    Optional <Admin> findByEmail(String emailAddress);
    Optional <Admin> findByLastName(String lastName);
}
