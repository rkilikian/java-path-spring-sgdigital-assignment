package gr.codelearn.spring.assignment.smdb.app.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CONTRIBUTORS")
@SequenceGenerator(name = "idGenerator", sequenceName = "CONTRIBUTORS_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Long.class)
public class Contributor extends BaseModel {
    @NotNull(message = "Contributor's first name should not be empty.")
    @Column(length = 20, nullable = false)
    private String firstName;

    @NotNull(message = "Contributor's last name should not be empty.")
    @Column(length = 30)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @JsonManagedReference("filmContributions")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contributor")
    //@JsonIgnore
    private final List<FilmContributor> filmContributions = new ArrayList<>();

    @JsonManagedReference("tvShowContributions")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contributor")
    //@JsonIgnore
    private final List<TVShowContributor> tvShowContributions = new ArrayList<>();
}
