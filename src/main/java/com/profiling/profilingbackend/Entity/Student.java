package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Student")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String studentID;

    @Column(nullable = false)
    private @Getter @Setter String firstName;

    @Column(nullable = false)
    private @Getter @Setter String lastName;

    @Column(nullable = false)
    private @Getter @Setter String gender;

    @Column(nullable = false)
    private @Getter @Setter String email;

    @Column(nullable = false)
    private @Getter @Setter String contactNumber;

    @Column(nullable = false)
    private @Getter @Setter String temporaryAddress;

    @Column(nullable = false)
    private @Getter @Setter String permanentsAddress;

    @DBRef
    private @Getter @Setter Course courses;

    @DBRef
    private @Getter @Setter List <Subjects> subjects;
}
