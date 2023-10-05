package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Document(collection = "Education")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Education {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String educationLevel;

    @Column(nullable = false)
    private @Getter @Setter String schoolName;

    @Column(nullable = false)
    private @Getter @Setter String gradeLevel;

    @Column(nullable = false)
    private @Getter @Setter LocalDate dateStarted;

    public String getFormattedDateStarted() {
        if (dateStarted != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
            return dateStarted.format(formatter);
        } else {
            return ""; // Or you can return null or any other default value.
        }
    }

    @Column(nullable = false)
    private @Getter @Setter LocalDate expectedGraduationYear;

    public String getFormattedExpectedGraduationYear(){
        if(expectedGraduationYear != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
            return expectedGraduationYear.format(formatter);
        }else{
            return "";
        }
    }


    @Column(nullable = false)
    private @Getter @Setter String schoolAddress;
}
