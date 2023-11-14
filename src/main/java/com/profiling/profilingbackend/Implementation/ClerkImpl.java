package com.profiling.profilingbackend.Implementation;

import com.profiling.profilingbackend.Entity.Clerk;
import com.profiling.profilingbackend.Repository.ClerkRepo;
import com.profiling.profilingbackend.Service.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
@Service
public class ClerkImpl implements ClerkService {

    @Autowired
    private ClerkRepo clerkRepo;

    @Override
    public ResponseEntity <String> createAccount(Clerk clerk){
        Optional <Clerk> existingUserName = clerkRepo.findByUserName(clerk.getUserName());
        Optional <Clerk> existingEmail = clerkRepo.findByEmail(clerk.getEmail());

        try{
           if(existingEmail.isEmpty() && existingUserName.isEmpty()){
               clerkRepo.save(clerk);
               return ResponseEntity.status(HttpStatus.OK).body(" ACCOUNT CREATED ");
           }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING BAD HAPPEN " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ACCOUNT DOES NOT EXIST ");
    }

    @Override
    public ResponseEntity <String> logInAsClerk(String userName, String email, String password){
        Clerk existingAccount = clerkRepo.findByUserNameAndEmailAndPassword(userName, email, password);

        try{
            if(existingAccount != null){
                return ResponseEntity.status(HttpStatus.OK).body(" LOG IN SUCCESSFULLY ");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" CLERK ACCOUNT DOES NOT EXIST ");
    }

    @Override
    public ResponseEntity <String> updateClerkAccount(String id, Clerk clerk){
        Clerk existingAccount = clerkRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        try{
            if(existingAccount != null){
                existingAccount.setEmail(clerk.getEmail());
                existingAccount.setUserName(clerk.getUserName());
                existingAccount.setPassword(clerk.getPassword());
                clerkRepo.save(existingAccount);
                return ResponseEntity.status(HttpStatus.OK).body(" CLERK ACCOUNT UPDATED ");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ACCOUNT DOES NOT EXIST ");
    }

    @Override
    public List <Clerk> queryClerks(){
        try{
            if(!clerkRepo.findAll().isEmpty()){
                return clerkRepo.findAll();
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity <String> deleteClerksData(String id){
        try{
            if(clerkRepo.findById(id).isPresent()){
                clerkRepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body(" CLERKS DATA DELETED SUCCESSFULLY ");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" DATA DOES NOT EXIST ");
    }

    @Override
    public Optional <Clerk> queryClerkByID(String id){
        try{
            if(clerkRepo.findById(id).isPresent()){
                return clerkRepo.findById(id);
            }
        }catch(Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }
}
