package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "StudentPersonalBackground")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String Gender;
    private @Getter @Setter String age;

    @DBRef
    private @Getter @Setter StudentEducationalBackground studentEducationalBackground;

    @DBRef
    private @Getter @Setter StudentFamilyBackground studentFamilyBackground;

}
