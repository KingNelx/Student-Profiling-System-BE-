package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Model.EducationalBG;
import com.profiling.profilingbackend.Repository.EducationalBGRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
@Service
public class EducationalImpl implements EducationalService{

    @Autowired
    private EducationalBGRepo educationalBGRepo;

    @Override
    public List <EducationalBG> getAllEducationalBG(){
        if(educationalBGRepo.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }
        return educationalBGRepo.findAll();
    }

    @Override
    public Optional <EducationalBG> getEducationalBGPerStudent(@PathVariable String id){
        if(!educationalBGRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return educationalBGRepo.findById(id);
    }

    @Override
    public ResponseEntity <String> removeEducationBGbyID(@PathVariable String id){
        if(!educationalBGRepo.findById(id).isPresent()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        educationalBGRepo.deleteById(id);
        return ResponseEntity.ok(" EDUCATIONAL BACKGROUND REMOVE g");
    }

}
