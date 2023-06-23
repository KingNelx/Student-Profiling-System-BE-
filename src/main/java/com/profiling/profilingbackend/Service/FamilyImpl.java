package com.profiling.profilingbackend.Service;
import com.profiling.profilingbackend.Model.FamilyBG;
import com.profiling.profilingbackend.Repository.FamilyBGRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

public class FamilyImpl implements FamilyService{

    @Autowired
    private FamilyBGRepo familyBGRepo;

    @Override
    public List <FamilyBG> getAllFamilyBG(){
        if(familyBGRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return familyBGRepo.findAll();
    }

    @Override
    public Optional <FamilyBG> getFamilyBGByID(@PathVariable String id){
        if(!familyBGRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return familyBGRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> removeFamilyBGbyID(@PathVariable String id){
        if(!familyBGRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        familyBGRepo.deleteById(id);
        return ResponseEntity.ok(" FAMILY BACKGROUND REMOVE ");
    }
}
