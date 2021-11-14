package gr.codelearn.spring.assignment.smdb.app.domain;

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
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TVSHOWS")
@SequenceGenerator(name = "idGenerator", sequenceName = "TV_SHOWS_SEQ", initialValue = 1, allocationSize = 1)
public class TVShow extends BaseModel {
    @NotNull(message = "TV Show's title should not be empty.")
    @Column(length = 50, nullable = false)
    private String title;

    @NotNull(message = "TV Show's genre should not be empty.")
    @Column(length = 15, nullable = false)
    private String genre;

    @NotNull
    @Column(nullable = false, columnDefinition = "smallint")
    private Year releaseYear;

    @Column(nullable = false)
    @Max(10)
    @Min(0)
    private double rating;

    @Column(nullable = false)
    private String plotSummary;

    @NotNull
    private int episodesCount;

    @NotNull
    private int seasonsCount;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tvShow")
    private final List<TVShowContributor> tvShowContributors = new ArrayList<>();
}
