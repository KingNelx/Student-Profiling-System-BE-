package com.profiling.profilingbackend.Service;

import com.profiling.profilingbackend.Entity.Student;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface StudentService {

    // add new student
    @Transactional
    ResponseEntity <String> addNewStudent(Student student);
}
