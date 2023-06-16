package com.profiling.profilingbackend.Model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
@Document(collection = "EducationalBG")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EducationalBG {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private @Getter @Setter String id;
    private @Getter @Setter String elementarySchool;
    private @Getter @Setter String yearGraduatedElementary;
    private @Getter @Setter String juniorHighSchool;
    private @Getter @Setter String yearGraduatedJuniorHigh;
    private @Getter @Setter String seniorHighSchool;
    private @Getter @Setter String yearGraduatedSeniorHigh;
    private @Getter @Setter String college;
    private @Getter @Setter String yearGraduatedCollege;
    @ElementCollection
    private @Getter @Setter List <String> elementaryAwards;
    @ElementCollection
    private @Getter @Setter List <String> juniorHighAwards;
    @ElementCollection
    private @Getter @Setter List <String> seniorHighAwards;
    @ElementCollection
    private @Getter @Setter List <String> collegeAwards;
}
