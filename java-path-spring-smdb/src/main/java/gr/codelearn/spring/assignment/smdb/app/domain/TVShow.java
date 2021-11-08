package gr.codelearn.spring.assignment.smdb.app.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(name = "TVSHOWS")
@SequenceGenerator(name = "idGenerator", sequenceName = "TVSHOWS_SEQ", initialValue = 1, allocationSize = 1)
public class TVShow  extends BaseModel {

    @NotNull
    private String title;

    @NotNull
    private String genre;

    @NotNull
    @Column(columnDefinition = "smallint")
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
    //private Set<TVShowContributor> contributors = new HashSet<TVShowContributor>();
}
