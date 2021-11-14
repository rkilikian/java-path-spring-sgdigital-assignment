package gr.codelearn.spring.assignment.smdb.app.repository;

import gr.codelearn.spring.assignment.smdb.app.domain.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TVShowRepository extends JpaRepository<TVShow, Long> {
    @Query("select s from TVShow s join fetch s.tvShowContributors sc join fetch sc.contributor c where s.id = ?1")
    TVShow findLazy(Long id);

    @Query("select distinct s from TVShow s join fetch s.tvShowContributors sc join fetch sc.contributor c")
    List<TVShow> findAllLazy();
}
