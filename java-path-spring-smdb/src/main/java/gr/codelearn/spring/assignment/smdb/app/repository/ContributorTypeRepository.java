package gr.codelearn.spring.assignment.smdb.app.repository;

import gr.codelearn.spring.assignment.smdb.app.domain.ContributorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributorTypeRepository extends JpaRepository<ContributorType, Long> {
}
