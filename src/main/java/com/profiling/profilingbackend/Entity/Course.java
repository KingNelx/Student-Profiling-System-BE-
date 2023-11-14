package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Course")
@Entity
public class Course {

    @Id
    @Column(nullable = false)
    private @Getter @Setter String courseID;

    @Column(nullable = false)
    private @Getter @Setter String courseName;

    @Column(nullable = false)
    private @Getter @Setter String courseCode;

    @Column(nullable = false)
    private @Getter @Setter String department;

}
