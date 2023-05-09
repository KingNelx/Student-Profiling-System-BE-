package com.profiling.profilingbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

import com.profiling.profilingbackend.Model.PersonalBG;
import com.profiling.profilingbackend.Repository.PersonalBGRepo;

@Service
public class PersonalBGImpl implements PersonalBGService{
 
    @Autowired
    private PersonalBGRepo personalBGRepo;

    @Override
    public List <PersonalBG> getAllPersonalBG(){
        if(!personalBGRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return personalBGRepo.findAll();
    }

    @Override
    public Optional <PersonalBG> getPersonalBGByID(@PathVariable String id){
        if(!personalBGRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return personalBGRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> updatePersonalBGByID(@PathVariable String id, @RequestBody PersonalBG newPersonalBG){
        
    }


}
