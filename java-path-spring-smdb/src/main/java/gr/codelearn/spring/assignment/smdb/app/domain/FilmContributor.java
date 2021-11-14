package gr.codelearn.spring.assignment.smdb.app.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({"film_id", "contributor_id"})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "FILMCONTRIBUTORS", indexes = {
        @Index(columnList = "film_id"),
        @Index(columnList = "contributor_id"),
        @Index(columnList = "contributortype_id")
})
@SequenceGenerator(name = "idGenerator", sequenceName = "FILM_CONTRIBUTORS_SEQ", initialValue = 1, allocationSize = 1)
public class FilmContributor extends BaseModel {
    @JsonBackReference("filmContributors")
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="film_id")
    private Film film;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="contributor_id")
    private Contributor contributor;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="contributortype_id")
    private ContributorType contributorType;
}
