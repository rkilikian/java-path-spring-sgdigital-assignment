package gr.codelearn.spring.assignment.smdb.app.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
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
    @NotNull(message = "Contributor's first name should not be empty.")
    @Column(length = 20, nullable = false)
    private String firstName;

    @NotNull(message = "Contributor's last name should not be empty.")
    @Column(length = 30)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;
}
