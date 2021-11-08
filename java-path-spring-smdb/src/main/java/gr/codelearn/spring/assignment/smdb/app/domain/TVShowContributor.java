package gr.codelearn.spring.assignment.smdb.app.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TVShowContributor  extends BaseModel {
    private TVShow tvShow;
    private Contributor contributor;
    private ContributorType contributorType;
}
