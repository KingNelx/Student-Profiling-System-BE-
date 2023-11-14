package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Subjects;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepo extends MongoRepository <Subjects, String> {
}
