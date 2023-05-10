package com.profiling.profilingbackend.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ElementCollection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "PersonalBG")
public class PersonalBG {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String lastName;
    private @Getter @Setter String firstName;
    private @Getter @Setter String middleName;
    private @Getter @Setter String emailAddress;
    private @Getter @Setter String yearLevel;
    private @Getter @Setter String block;
    private @Getter @Setter String mobileNumber;
    private @Getter @Setter String course;
    private @Getter @Setter String gender;
    private @Getter @Setter int age;
    @ElementCollection
    private @Getter @Setter List <String> civilStatusAndReligion;
    private @Getter @Setter String language;
    private @Getter @Setter String dateOfBirth;
    private @Getter @Setter String placeOfBirth;
    private @Getter @Setter String permanentAndCurrentAddress;
}
