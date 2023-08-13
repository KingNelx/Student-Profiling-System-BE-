package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "StudentEducationalBackground")
@AllArgsConstructor
@NoArgsConstructor

public class StudentEducationalBackground {

    @Id
    private @Getter @Setter String id;
    private @Getter @Setter String elementarySchool;
    private @Getter @Setter String elementarySchoolYearStarted;
    private @Getter @Setter String elementarySchoolYearEnded;
    private @Getter @Setter String elementarySchoolAddress;

    // high school
    private @Getter @Setter String highSchool;
    private @Getter @Setter String highSchoolYearStarted;
    private @Getter @Setter String highSchoolYearEnded;
    private @Getter @Setter String highSchoolAddress;

    // senior high school
    private @Getter @Setter String seniorHighSchool;
    private @Getter @Setter String seniorHighYearStarted;
    private @Getter @Setter String seniorHighYearEnded;
    private @Getter @Setter String seniorHighAddress;

    // college
    private @Getter @Setter String college;
    private @Getter @Setter String collegeYearStarted;
    private @Getter @Setter String collegeYearEnded;
    private @Getter @Setter String collegeAddress;

}
