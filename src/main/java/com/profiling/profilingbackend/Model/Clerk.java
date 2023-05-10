package com.profiling.profilingbackend.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document (collection = "Clerk")
public class Clerk {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String userName;
    private @Getter @Setter String password;
    private @Getter @Setter String email;

}
