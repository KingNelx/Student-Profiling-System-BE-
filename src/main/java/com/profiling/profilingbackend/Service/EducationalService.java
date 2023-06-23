package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Model.EducationalBG;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface EducationalService {

    List <EducationalBG> getAllEducationalBG();
    Optional <EducationalBG> getEducationalBGPerStudent(String id);
    ResponseEntity <String> removeEducationBGbyID(String id);

}
