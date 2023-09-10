package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "Education")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Education {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String educationLevel;

    @Column(nullable = false)
    private @Getter @Setter String schoolName;

    @Column(nullable = false)
    private @Getter @Setter String gradeLevel;

    @Column(nullable = false)
    private @Getter @Setter LocalDate dateStarted;

    @Column(nullable = false)
    private @Getter @Setter LocalDate expectedGraduationYear;

    @Column(nullable = false)
    private @Getter @Setter String schoolAddress;
}
