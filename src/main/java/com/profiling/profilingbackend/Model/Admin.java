package com.profiling.profilingbackend.Model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Admin")
public class Admin {

    @Id
    @GeneratedValue
    private @Getter @Setter String id;
    @Column (nullable = false)
    private @Getter @Setter String firstName;
    @Column (nullable = false)
    private @Getter @Setter String lastName;
    @Column (nullable = false)
    private @Getter @Setter String userName;
    @Column (nullable = false)
    private @Getter @Setter String email;
    @Column (nullable = false)
    private @Getter @Setter String password;
}
