package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.StudentFamilyBackground;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentFamilyRepo extends MongoRepository <StudentFamilyBackground, String> {
}
