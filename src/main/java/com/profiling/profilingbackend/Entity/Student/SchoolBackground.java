package com.profiling.profilingbackend.Entity.Student;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SchoolBackground")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SchoolBackground {
    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String studentID;

    @Column(nullable = false)
    private @Getter @Setter String course;

    @Column(nullable = false)
    private @Getter @Setter String yearLevel;

    @Column(nullable = false)
    private @Getter @Setter String block;

    @Column(nullable = false)
    private @Getter @Setter String email;

    @Column(nullable = false)
    private @Getter @Setter String mobileNumber;
}
