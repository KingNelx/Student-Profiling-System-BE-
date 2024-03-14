package com.profiling.profilingbackend.Implementation;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Repository.ClerkRepo;
import com.profiling.profilingbackend.Service.ClerkService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class ClerkImpl implements ClerkService {

    @Autowired
    private ClerkRepo clerkRepo;

    @Override
    public ResponseEntity<String> createAccount(@RequestBody Clerk newAccount) {
        if (newAccount.getId() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" REQUEST BODY CAN NOT BE NULL ");
        }

        if (clerkRepo.existsById(newAccount.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" ID ALREADY EXIST ");
        }

        try {
            Optional<Clerk> existingFirstName = clerkRepo.findByFirstName(newAccount.getFirstName());
            Optional<Clerk> existingLastName = clerkRepo.findByLastName(newAccount.getLastName());
            Optional<Clerk> existingEmail = clerkRepo.findByEmailAddress(newAccount.getEmailAddress());

            if (existingFirstName.isPresent() && existingLastName.isPresent() && existingEmail.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DATA ALREADY EXIST");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        clerkRepo.save(newAccount);
        return ResponseEntity.status(HttpStatus.OK).body(" CLERK ACCOUNT CREATED ");
    }

    @Override
    public ResponseEntity<String> logInAsClerk(@PathVariable String firstName, @PathVariable String lastName,
            @PathVariable String emailAddress, @PathVariable String role, @PathVariable String userName,
            @PathVariable String password) {

        Clerk existingAccount = clerkRepo.findByFirstNameAndLastNameAndEmailAddressAndRoleAndUserNameAndPassword(
                firstName, lastName, emailAddress, role, userName, password);

        if (firstName == null || lastName == null || emailAddress == null || role == null || userName == null
                || password == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" INVALID INPUT ");
        }

        if (firstName.isEmpty() || lastName.isEmpty() || emailAddress.isEmpty() || role.isEmpty() || userName.isEmpty()
                || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" DETAILS MUST NOT BE EMPTY ");
        }

        try {
            if (existingAccount == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" ACCOUNT NOT FOUND ");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(" SUCCESSFULLY LOG IN ");
    }

    @Override
    public Optional<Clerk> findClerkByID(Long id) {
        if (clerkRepo.existsById(id)) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT);
        }

        Optional<Clerk> existingID = clerkRepo.findById(id);

        try {
            if (!existingID.isPresent()) {
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return existingID;
    }
}
