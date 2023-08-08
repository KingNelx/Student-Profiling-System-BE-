package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.StudentPersonalBackground;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentPersonalRepo extends MongoRepository <StudentPersonalBackground, String>{
}
