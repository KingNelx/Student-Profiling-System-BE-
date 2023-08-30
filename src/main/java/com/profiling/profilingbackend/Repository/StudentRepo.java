package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.List;

public interface StudentRepo extends MongoRepository <Student, String>{

    Optional <Student> findByFirstName(String firstname);
    Optional <Student> findByLastName(String lastname);
    List <Student> findByGender(String gender);

}
