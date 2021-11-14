package gr.codelearn.spring.assignment.smdb.app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TVSHOWCONTRIBUTORS", indexes = {
        @Index(columnList = "tvshow_id"),
        @Index(columnList = "contributor_id"),
        @Index(columnList = "contributortype_id")
})
@SequenceGenerator(name = "idGenerator", sequenceName = "TV_SHOW_CONTRIBUTORS_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Long.class)
public class TVShowContributor  extends BaseModel {
    @JsonBackReference("tvShowContributors")
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tvshow_id")
    private TVShow tvShow;

    @JsonBackReference("tvShowContributions")
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="contributor_id")
    //@JsonIgnore
    private Contributor contributor;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="contributortype_id")
    private ContributorType contributorType;
}
