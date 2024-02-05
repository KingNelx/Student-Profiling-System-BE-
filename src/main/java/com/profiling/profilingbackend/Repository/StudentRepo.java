package com.profiling.profilingbackend.Repository;

import com.profiling.profilingbackend.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

    Optional<Student> findByFirstName(String firstName);

    Optional<Student> findByLastName(String lastName);

    Optional<Student> findByStudentId(String studentId);

    List<Student> findByAcademicLevel(String academicLevel);

    List<Student> findByGender(String gender);

    Long countByGender(String gender);
}
