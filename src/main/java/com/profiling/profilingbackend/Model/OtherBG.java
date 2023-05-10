package com.profiling.profilingbackend.Model;


import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document (collection = "OtherBG")
public class OtherBG {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private @Getter @Setter String id;
    @ElementCollection
    private @Getter @Setter List <String> healthConditions;
    @ElementCollection
    private @Getter @Setter List <String> pregnantInfo;
    @ElementCollection
    private @Getter @Setter List <String> schoolarProgram;
}
