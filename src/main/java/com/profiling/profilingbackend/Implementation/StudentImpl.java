package com.profiling.profilingbackend.Implementation;

import com.profiling.profilingbackend.Entity.Student;
import com.profiling.profilingbackend.Repository.CourseRepo;
import com.profiling.profilingbackend.Repository.StudentRepo;
import com.profiling.profilingbackend.Repository.SubjectRepo;
import com.profiling.profilingbackend.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public ResponseEntity <String> addStudent(@RequestBody Student student){
        
    }

}
