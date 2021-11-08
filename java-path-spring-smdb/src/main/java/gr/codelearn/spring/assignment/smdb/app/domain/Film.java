package gr.codelearn.spring.assignment.smdb.app.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "FILMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "FILMS_SEQ", initialValue = 1, allocationSize = 1)
public class Film  extends BaseModel {
    @NotNull(message = "Film's title should not be empty.")
    @Column(length = 50, nullable = false)
    private String title;

    @NotNull(message = "Film's genre should not be empty.")
    @Column(length = 50, nullable = false)
    private String genre;

    @Column(nullable = false, columnDefinition = "smallint")
    private Year releaseYear;

    @Column(nullable = false)
    @Max(10)
    @Min(0)
    private double rating;

    @Column(nullable = false)
    private String plotSummary;

    //@JsonManagedReference("filmContributors")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "film")
    private final Set<FilmContributor> filmContributors = new HashSet<>();
}
