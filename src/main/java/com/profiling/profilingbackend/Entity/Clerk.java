package com.profiling.profilingbackend.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "Clerk")
@AllArgsConstructor
@NoArgsConstructor
public class Clerk {

    @Id
    private @Getter @Setter String id;

}
