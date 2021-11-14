package gr.codelearn.spring.assignment.smdb.app.repository;

import gr.codelearn.spring.assignment.smdb.app.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("select f from Film f join fetch f.filmContributors where f.id = ?1")
    Film findLazy(Long id);

    @Query("select distinct f from Film f join fetch f.filmContributors fc join fetch fc.contributor c")
    List<Film> findAllLazy();
}
