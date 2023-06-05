package com.profiling.profilingbackend.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Clerk {

    @Id
    @GeneratedValue
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String userName;
    private @Getter @Setter String email;
    private @Getter @Setter String password;

}
