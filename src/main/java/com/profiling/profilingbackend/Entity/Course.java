package com.profiling.profilingbackend.Entity;

import lombok.Setter;
import lombok.Getter;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "Course")
public class Course {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String courseCode;

    @Column(nullable = false)
    private @Getter @Setter String courseTitle;

    @Column(nullable = false)
    private @Getter @Setter String description;

    @Column(nullable = false)
    private @Getter @Setter String instructor;

    @Column(nullable = false)
    private @Getter @Setter String schedule;

    @Column(nullable = false)
    private @Getter @Setter String semester;
}
