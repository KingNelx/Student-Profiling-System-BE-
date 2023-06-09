package com.profiling.profilingbackend.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document (collection = "Clerk")
@AllArgsConstructor
@NoArgsConstructor
public class Clerk {

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
