package com.profiling.profilingbackend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
