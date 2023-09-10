package com.profiling.profilingbackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Clerk")
public class Clerk {
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
