package com.profiling.profilingbackend.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "EducationalBG")
public class EducationalBG {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String elementarySchool;
    private @Getter @Setter String elementaryYearGraduated;
    private @Getter @Setter String elementaryAcademicAward;
    private @Getter @Setter String elementarySchoolAddress;

    private @Getter @Setter String highSchool;
    private @Getter @Setter String highSchoolYearGraduated;
    private @Getter @Setter String highSchoolAcademicAward;
    private @Getter @Setter String highSchoolAddress;

    private @Getter @Setter String seniorHighSchool;
    private @Getter @Setter String seniorHighYearGraduated;
    private @Getter @Setter String seniorHighAcademicAward;
    private @Getter @Setter String seniorHighAddress;

    private @Getter @Setter String collegeSchool;
    private @Getter @Setter String collegeYearGraduated;
    private @Getter @Setter String collegeAcademicAward;
    private @Getter @Setter String collegeAddress;
}
