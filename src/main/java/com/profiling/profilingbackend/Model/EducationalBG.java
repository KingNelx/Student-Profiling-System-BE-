package com.profiling.profilingbackend.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document (collection = "EducationalBG")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EducationalBG {
    
    @Id
    private @Getter @Setter String id;
    
    // elementary
    private @Getter @Setter String elementarySchool;
    private @Getter @Setter String yearGraduatedElem;
    private @Getter @Setter String academicAwardsElem;
    // junior high
    private @Getter @Setter String juniorHighSchool;
    private @Getter @Setter String yearGraduatedHs;
    private @Getter @Setter String academicAwardsHs;
    // senior high
    private @Getter @Setter String seniorHighSchool;
    private @Getter @Setter String yearGraduatedShs;
    private @Getter @Setter String academicAwardsShs;
    // college
    private @Getter @Setter String collegeSchool;
    private @Getter @Setter String yearGraduatedCollege;
    private @Getter @Setter String academicAwardsCollege;
}
