package com.profiling.profilingbackend.Entity;

import jakarta.persistence.ElementCollection;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "Student")
public class Student {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String firstName;

    @Column(nullable = false)
    private @Getter @Setter String middleInitial;

    @Column(nullable = false)
    private @Getter @Setter String lastName;

    @Column(nullable = false)
    private @Getter @Setter String studentId;

    @Column(nullable = false)
    private @Getter @Setter LocalDate dateOfBirth;

    @Column(nullable = false)
    private @Getter @Setter String gender;

    @Column(nullable = false)
    private @Getter @Setter String temporaryAddress;

    @Column(nullable = false)
    private @Getter @Setter String permanentAddress;

    @Column(nullable = false)
    private @Getter @Setter String contactInformation;

    @Column(nullable = false)
    private @Getter @Setter String academicLevel;

    @DBRef
    @ElementCollection
    private @Getter @Setter List <Course> myCourse;
}
