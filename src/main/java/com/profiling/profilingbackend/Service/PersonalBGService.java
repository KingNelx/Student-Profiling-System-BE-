package com.profiling.profilingbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profiling.profilingbackend.Model.PersonalBG;

@Service
public interface PersonalBGService {
    
    // select all personal bg
    List <PersonalBG> getAllPersonalBG();

    // select personal bg by id
    Optional <PersonalBG> getPersonalBGByID(String id);

    // edit personal bg by id
    ResponseEntity <String> updatePersonalBGByID(String id, PersonalBG newPersonalBG);

    // delete personal bg by id
}
