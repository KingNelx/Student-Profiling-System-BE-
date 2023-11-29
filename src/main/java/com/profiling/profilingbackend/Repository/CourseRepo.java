package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepo extends MongoRepository <Course, String> {

}
