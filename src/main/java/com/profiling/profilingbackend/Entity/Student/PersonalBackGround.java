package com.profiling.profilingbackend.Entity.Student;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.ElementCollection;

import java.time.LocalDate;
import java.util.List;
@Document(collection = "PersonalBackground")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonalBackGround {
    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String age;

    @Column(nullable = false)
    private @Getter @Setter String gender;

    @Column(nullable = false)
    private @Getter @Setter String civilStatus;

    @Column(nullable = false)
    @ElementCollection
    private @Getter @Setter List <String> language;

    @Column(nullable = false)
    private @Getter @Setter LocalDate dateOfBirth;

    @Column(nullable = false)
    private @Getter @Setter String placeOfBirth;

    @Column(nullable = false)
    private @Getter @Setter String permanentAddress;

    @Column(nullable = false)
    private @Getter @Setter String currentAddress;

    @DBRef
    private @Getter @Setter SchoolBackground schoolBackground;

    @DBRef
    private @Getter @Setter EducationalBackground educationalBackground;
}
