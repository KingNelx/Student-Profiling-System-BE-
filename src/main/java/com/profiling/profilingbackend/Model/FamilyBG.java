package com.profiling.profilingbackend.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document (collection = "FamilyBG")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FamilyBG {
    
    @Id
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
