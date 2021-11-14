package gr.codelearn.spring.assignment.smdb.app.repository;

import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor, Long> {
    @Query("select c from Contributor c where c.id = ?1")
    Contributor findLazy(Long id);

    @Query("select c from Contributor c where lower(c.firstName) = ?1")
    List<Contributor> findByFirstName(String firstName);

    @Query("select c from Contributor c where lower(c.lastName) = ?1")
    List<Contributor> findByLastName(String lastName);

    @Query("select distinct c from Contributor c")
    List<Contributor> findAllLazy();
    
}
