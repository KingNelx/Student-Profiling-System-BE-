package com.profiling.profilingbackend.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FamilyBG")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FamilyBG {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String fathersName;
    private @Getter @Setter String fathersOccupation;
    private @Getter @Setter String fathersAge;
    private @Getter @Setter String fathersHighestEducation;
    private @Getter @Setter String mothersName;
    private @Getter @Setter String mothersOccupation;
    private @Getter @Setter String mothersAge;
    private @Getter @Setter String mothersHighestEducation;
}
