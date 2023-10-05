package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Parents")

public class  Parents {

    @Id
    private @Getter @Setter String id;


    @Column(nullable=false)
    private @Getter @Setter String fathersFullName;

    @Column(nullable=false)
    private @Getter @Setter String fathersAge;

    @Column(nullable = false)
    private @Getter @Setter String fathersAddress;

    @Column(nullable = false)
    private @Getter @Setter String fathersContactNumber;

    @Column(nullable = false)
    private @Getter @Setter String fathersCivilStatus;

    @Column(nullable = false)
    private @Getter @Setter String fathersOccupation;

    @Column(nullable = false)
    private @Getter @Setter String fathersEducationLevel;

    @Column(nullable = false)
    private @Getter @Setter LocalDate fathersDateOfBirth;


    @Column(nullable=false)
    private @Getter @Setter String mothersFullName;

    @Column(nullable=false)
    private @Getter @Setter String mothersAge;

    @Column(nullable = false)
    private @Getter @Setter String mothersAddress;

    @Column(nullable = false)
    private @Getter @Setter String mothersContactNumber;

    @Column(nullable = false)
    private @Getter @Setter String mothersCivilStatus;

    @Column(nullable = false)
    private @Getter @Setter String mothersOccupation;

    @Column(nullable = false)
    private @Getter @Setter String mothersEducationLevel;

    @Column(nullable = false)
    private @Getter @Setter LocalDate mothersDateOfBirth;


    public String getFormatterFathersDateOfBirth(){
        if(fathersDateOfBirth != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
            return fathersDateOfBirth.format(formatter);
        }else{
            return "";
        }
    }


    public String getFormatterMothersDateOfBirth(){
        if(mothersDateOfBirth != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
            return mothersDateOfBirth.format(formatter);
        }else{
            return "";
        }
    }

}
