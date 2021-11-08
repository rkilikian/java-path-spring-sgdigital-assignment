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
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CONTRIBUTORTYPE")
@SequenceGenerator(name = "idGenerator", sequenceName = "CONTRIBUTOR_TYPE_SEQ", initialValue = 1, allocationSize = 1)
public class ContributorType  extends BaseModel {
    @NotNull(message = "Contributor's type description should be present.")
    @Column(length = 20, nullable = false)
    private String description;
}
