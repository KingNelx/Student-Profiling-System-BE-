package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Model.FamilyBG;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyBGRepo extends MongoRepository <FamilyBG, String> {
}
