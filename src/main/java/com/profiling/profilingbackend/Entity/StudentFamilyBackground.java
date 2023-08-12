package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "StudentFamilyBackground")
@AllArgsConstructor
@NoArgsConstructor
public class StudentFamilyBackground {
    @Id
    private @Getter @Setter String id;
    private @Getter @Setter String fathersFirstName;
    private @Getter @Setter String fathersLastName;
    private @Getter @Setter String fathersAddress;
    private @Getter @Setter String fathersCivilStatus;
    private @Getter @Setter String fathersAge;
    private @Getter @Setter String fathersContactNumber;
    private @Getter @Setter String fathersOccupation;
    private @Getter @Setter String fathersHighestEducation;

    // mother side
    private @Getter @Setter String mothersFirstName;
    private @Getter @Setter String mothersLastName;
    private @Getter @Setter String mothersAddress;
    private @Getter @Setter String mothersCivilStatus;
    private @Getter @Setter String mothersAge;
    private @Getter @Setter String mothersContactNumber;
    private @Getter @Setter String mothersOccupation;
    private @Getter @Setter String mothersHighestEducation;

}
