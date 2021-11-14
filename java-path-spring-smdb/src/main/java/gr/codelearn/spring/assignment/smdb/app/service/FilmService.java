package gr.codelearn.spring.assignment.smdb.app.service;

import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;
import gr.codelearn.spring.assignment.smdb.app.domain.ContributorType;
import gr.codelearn.spring.assignment.smdb.app.domain.Film;

import java.util.List;

public interface FilmService extends BaseService<Film, Long> {

    void addFilmContributor(Film film, Contributor contributor, ContributorType contributorType);

    Film findLazy(Long id);

    List<Film> findAllLazy();

}
