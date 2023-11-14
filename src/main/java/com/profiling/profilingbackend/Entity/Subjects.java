package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "Subjects")
public class Subjects {

    @Id
    @Column(nullable = false)
    private @Getter @Setter String subjectID;

    @Column(nullable = false)
    private @Getter @Setter String subjectName;

    @Column(nullable = false)
    private @Getter @Setter String subjectCode;

    @Column(nullable = false)
    private @Getter @Setter String schedule;

    @Column(nullable = false)
    private @Getter @Setter String instructor;
}
