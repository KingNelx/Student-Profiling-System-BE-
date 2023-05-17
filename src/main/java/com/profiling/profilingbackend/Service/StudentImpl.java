package com.profiling.profilingbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.profiling.profilingbackend.Model.EducationalBG;
import com.profiling.profilingbackend.Model.FamilyBG;
import com.profiling.profilingbackend.Model.OtherBG;
import com.profiling.profilingbackend.Model.PersonalBG;
import com.profiling.profilingbackend.Model.Student;
import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl {
    
    @Autowired
    private Student studentRepo;

    @Autowired
    private PersonalBG personalBG;

    @Autowired
    private EducationalBG educationalBG;

    @Autowired
    private FamilyBG familyBG;

    @Autowired
    private OtherBG otherBG;

    @Override
    public Student registerStudent(@RequestBody Student registerStudent){
        
    }

}
