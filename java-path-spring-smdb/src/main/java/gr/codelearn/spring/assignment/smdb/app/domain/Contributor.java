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
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CONTRIBUTORS")
@SequenceGenerator(name = "idGenerator", sequenceName = "CONTRIBUTORS_SEQ", initialValue = 1, allocationSize = 1)
public class Contributor extends BaseModel {
    @NotNull(message = "Customer's first name should not be empty.")
    @Column(length = 20, nullable = false)
    private String firstName;

    @NotNull(message = "Customer's last name should not be empty.")
    @Column(length = 30)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;
}
