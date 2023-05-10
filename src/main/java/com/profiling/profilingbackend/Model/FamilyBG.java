package com.profiling.profilingbackend.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document (collection = "FamilyBG")
public class FamilyBG {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)    
    private @Getter @Setter String id;
    private @Getter @Setter String fathersName;
    private @Getter @Setter String fathersOccupation;
    private @Getter @Setter String fathersReligion;
    private @Getter @Setter int fathersAge;
    private @Getter @Setter String fathersEducationalAttainment;
    private @Getter @Setter String fathersMonthlyIncome;

    private @Getter @Setter String mothersName;
    private @Getter @Setter String mothersOccupation;
    private @Getter @Setter String mothersReligion;
    private @Getter @Setter int mothersAge;
    private @Getter @Setter String mothersEducationalAttainment;
    private @Getter @Setter String mothersMonthlyIncome;

    private @Getter @Setter String maritalStatus;
}
