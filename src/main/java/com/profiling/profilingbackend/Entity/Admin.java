package com.profiling.profilingbackend.Entity;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String firstName;

    @Column(nullable = false)
    private @Getter @Setter String lastName;

    @Column(nullable = false)
    private @Getter @Setter String email;

    @Column(nullable = false)
    private @Getter @Setter String userName;

    @Column(nullable = false)
    private @Getter @Setter String password;
}
