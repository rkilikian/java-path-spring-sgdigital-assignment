package gr.codelearn.spring.assignment.smdb.app.service;

import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;
import gr.codelearn.spring.assignment.smdb.app.domain.ContributorType;
import gr.codelearn.spring.assignment.smdb.app.domain.Film;
import gr.codelearn.spring.assignment.smdb.app.domain.FilmContributor;
import gr.codelearn.spring.assignment.smdb.app.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FilmRepository filmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return filmRepository;
    }

    @Override
    public void addFilmContributor(Film film, Contributor contributor, ContributorType contributorType) {
        film.getFilmContributors().add(newFilmContributor(film, contributor, contributorType));
    }

    private FilmContributor newFilmContributor(Film film, Contributor contributor, ContributorType contributorType) {
        return FilmContributor.builder().film(film).contributor(contributor).contributorType(contributorType).build();
    }

    @Override
    public Film findLazy(Long id) {
        return filmRepository.findLazy(id);
    }

    @Override
    public List<Film> findAllLazy() {
        return filmRepository.findAllLazy();
    }

}