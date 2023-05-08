package com.profiling.profilingbackend.Model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document (collection = "Student")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private @Getter @Setter String id;
    private @Getter @Setter String studentID;
    private @Getter @Setter String password;

    @DBRef
    private @Getter @Setter PersonalBG personalBG;
    @DBRef
    private @Getter @Setter EducationalBG educationalBG;
    @DBRef
    private @Getter @Setter FamilyBG familyBG;
    @DBRef
    private @Getter @Setter OtherBG otherBG;
    
}
