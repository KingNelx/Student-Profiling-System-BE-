package com.profiling.profilingbackend.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document (collection = "EducationalBG")
public class EducationalBG {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String elementarySchool;
    private @Getter @Setter String yearGraduatedElementary;
    private @Getter @Setter String academicHonorsElementary;

    private @Getter @Setter String juniorHighSchool;
    private @Getter @Setter String yearGraduatedJuniorHigh;
    private @Getter @Setter String academicHonorsJuniorHigh;

    private @Getter @Setter String seniorHighSchool;
    private @Getter @Setter String yearGraduatedSeniorHigh;
    private @Getter @Setter String academicHonorsSeniorHigh;

    private @Getter @Setter String collegeSchool;
    private @Getter @Setter String yearGraduatedCollege;
    private @Getter @Setter String academicHonorsCollege;
}
