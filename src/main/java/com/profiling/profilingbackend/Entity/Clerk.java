package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "Clerk")
public class Clerk {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String email;

    @Column(nullable = false)
    private @Getter @Setter String userName;

    @Column(nullable = false)
    private @Getter @Setter String password;

    @Column(nullable = false)
    private @Getter @Setter String confirmPassword;
}
