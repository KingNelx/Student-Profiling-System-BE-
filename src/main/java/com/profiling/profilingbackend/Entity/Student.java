package com.profiling.profilingbackend.Entity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Document(collection = "Student")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @Id
    private @Getter @Setter String id;

    @Column(nullable=false)
    private @Getter @Setter String studentID;

    @Column(nullable=false)
    private @Getter @Setter String firstName;

    @Column(nullable = false)
    private @Getter @Setter String lastName;

    @Column(nullable=false)
    private @Getter @Setter String middleInitial;

    @Column(nullable=false)
    private @Getter @Setter LocalDate dateOfBirth;

    @Column(nullable = false)
    private @Getter @Setter String gender;

    @Column(nullable=false)
    private @Getter @Setter String contactNumber;

    @Column(nullable=false)
    private @Getter @Setter String emailAddress;

    @Column(nullable = false)
    private @Getter @Setter String address;

    @DBRef
    private @Getter @Setter Education education;

    @DBRef
    private @Getter @Setter Parents parents;

    public String getFormattedDateOfBirth(){
        if(dateOfBirth != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
            return dateOfBirth.format(formatter);
        }else{
            return "";
        }
    }
}
