package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Parents;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParentRepo extends MongoRepository <Parents, String> {
}
