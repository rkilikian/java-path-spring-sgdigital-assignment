package gr.codelearn.spring.assignment.smdb.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "FILMCONTRIBUTORS")
@SequenceGenerator(name = "idGenerator", sequenceName = "FILM_CONTRIBUTORS_SEQ", initialValue = 1, allocationSize = 1)
public class FilmContributor extends BaseModel {
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Contributor contributor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ContributorType contributorType;
}
