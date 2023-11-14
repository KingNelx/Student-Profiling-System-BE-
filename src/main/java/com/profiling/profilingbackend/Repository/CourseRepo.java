package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepo extends MongoRepository <Course, String> {
}
