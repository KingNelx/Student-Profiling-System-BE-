package com.profiling.profilingbackend.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document (collection = "Clerk")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clerk {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String email;
    private @Getter @Setter String userName;
    private @Getter @Setter String password;

    
}
