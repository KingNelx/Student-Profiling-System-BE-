package com.profiling.profilingbackend.Services;

import com.profiling.profilingbackend.Entity.Education;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface EducationService {

    List <Education> fetchAllElementary();
    List <Education> fetchAllHighSchool();
    List <Education> fetchAllSeniorHigh();
    List <Education> fetchAllVocational();
    List <Education> fetchAllCollege();
}
