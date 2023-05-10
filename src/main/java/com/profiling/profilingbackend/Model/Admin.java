package com.profiling.profilingbackend.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Admin")
public class Admin {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String email;
    private @Getter @Setter String userName;
    private @Getter @Setter String password;
}
