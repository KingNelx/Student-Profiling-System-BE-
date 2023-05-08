package com.profiling.profilingbackend.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Document (collection = "OtherBG")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OtherBG {
    
    @Id
    private @Getter @Setter String id;
    @ElementCollection
    private @Getter @Setter List <String> healthConditions;
    @ElementCollection
    private @Getter @Setter List <String> isPregnantMonths;
    @ElementCollection
    private @Getter @Setter List <String> isSchoolarName;
}
