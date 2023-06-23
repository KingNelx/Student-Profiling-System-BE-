package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Model.FamilyBG;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface FamilyService {

    List <FamilyBG> getAllFamilyBG();
    Optional <FamilyBG> getFamilyBGByID(String id);
    ResponseEntity <String> removeFamilyBGbyID(String id);
}
