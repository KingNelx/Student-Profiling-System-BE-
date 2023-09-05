package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepo extends MongoRepository <Admin, String> {
}
