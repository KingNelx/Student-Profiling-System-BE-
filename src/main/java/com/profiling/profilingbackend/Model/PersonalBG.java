package com.profiling.profilingbackend.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document (collection = "PersonalBG")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonalBG {

    @Id
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String middleName;
    private @Getter @Setter String emailAddress;
    private @Getter @Setter String yearLevel;
    private @Getter @Setter String block;
    private @Getter @Setter String mobileNumber;
    private @Getter @Setter String course;
    private @Getter @Setter String gender;
    private @Getter @Setter int age;
    private @Getter @Setter String civilStatus;
    private @Getter @Setter String religion;
    private @Getter @Setter String language;
    private @Getter @Setter String dateOfBirth;
    private @Getter @Setter String placeOfBirth;
    private @Getter @Setter String permanentAddress;
    private @Getter @Setter String currentAddress;

    
}
