package com.profiling.profilingbackend.Services;

import com.profiling.profilingbackend.Entity.Education;
import com.profiling.profilingbackend.Repository.EducationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
@Service

public class EducationImpl implements EducationService{

    @Autowired
    private EducationRepo educationRepo;

    @Override
    public List <Education> fetchAllElementary(){
        try{
            if(!educationRepo.findByEducationLevel("ELEMENTARY").isEmpty()){
                return educationRepo.findByEducationLevel("ELEMENTARY");
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public List <Education> fetchAllHighSchool(){
        try{
            if(!educationRepo.findByEducationLevel("HIGH SCHOOL").isEmpty()){
                return educationRepo.findByEducationLevel("HIGH SCHOOL");
            }
        }catch(Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public List <Education> fetchAllSeniorHigh(){
        try{
            if(!educationRepo.findByEducationLevel("SENIOR HIGH").isEmpty()){
                return educationRepo.findByEducationLevel("SENIOR HIGH");
            }
        }catch(Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public List <Education> fetchAllVocational(){
        try{
            if(!educationRepo.findByEducationLevel("VOCATIONAL").isEmpty()){
                return educationRepo.findByEducationLevel("VOCATIONAL");
            }
        }catch(Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public List <Education> fetchAllCollege(){
        try{
            if(!educationRepo.findByEducationLevel("COLLEGE").isEmpty()){
                return educationRepo.findByEducationLevel("COLLEGE");
            }
        }catch(Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

}
