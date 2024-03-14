package com.profiling.profilingbackend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.profiling.profilingbackend.Entity.Clerk;
import java.util.Optional;

@Repository
public interface ClerkRepo extends MongoRepository<Clerk, Long> {
    Optional<Clerk> findByFirstName(String firstName);

    Optional<Clerk> findByLastName(String lastName);

    Optional<Clerk> findByEmailAddress(String emailAddress);

    Clerk findByFirstNameAndLastNameAndEmailAddressAndRoleAndUserNameAndPassword(
            String firstName, String lastName, String emailAddress, String role, String userName, String password);
}
