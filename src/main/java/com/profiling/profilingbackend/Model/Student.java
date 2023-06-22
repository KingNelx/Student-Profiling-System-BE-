package com.profiling.profilingbackend.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Student")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String studentID;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter int age;
    private @Getter @Setter String gender;
    private @Getter @Setter String course;
    private @Getter @Setter String email;
    private @Getter @Setter String contactNumber;

    @DBRef
    private @Getter @Setter EducationalBG educationalBG;
    @DBRef
    private @Getter @Setter FamilyBG familyBG;

}
