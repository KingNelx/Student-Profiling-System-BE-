package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Column;

@Document(collection = "CLERK")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Clerk {

    @Id
    private @Getter @Setter Long id;

    @Column(nullable = false)
    private @Getter @Setter String firstName;

    @Column(nullable = false)
    private @Getter @Setter String lastName;

    @Column(nullable = false)
    private @Getter @Setter String emailAddress;

    @Column(nullable = false)
    private @Getter @Setter String role;

    @Column(nullable = false)
    private @Getter @Setter String userName;

    @Column(nullable = false)
    private @Getter @Setter String password;
}
