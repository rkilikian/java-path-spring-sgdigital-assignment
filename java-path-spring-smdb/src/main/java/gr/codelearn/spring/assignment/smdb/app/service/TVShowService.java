package gr.codelearn.spring.assignment.smdb.app.service;

import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;
import gr.codelearn.spring.assignment.smdb.app.domain.ContributorType;
import gr.codelearn.spring.assignment.smdb.app.domain.TVShow;

import java.util.List;

public interface TVShowService extends BaseService<TVShow, Long> {
    void addTVShowContributor(TVShow tvShow, Contributor contributor, ContributorType contributorType);

    TVShow findLazy(Long id);

    List<TVShow> findAllLazy();
}
