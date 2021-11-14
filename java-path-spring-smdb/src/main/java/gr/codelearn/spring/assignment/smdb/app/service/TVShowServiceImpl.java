package gr.codelearn.spring.assignment.smdb.app.service;

import gr.codelearn.spring.assignment.smdb.app.domain.*;
import gr.codelearn.spring.assignment.smdb.app.repository.TVShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TVShowServiceImpl extends BaseServiceImpl<TVShow> implements TVShowService {
    private final TVShowRepository tvShowRepository;

    @Override
    public JpaRepository<TVShow, Long> getRepository() {
        return tvShowRepository;
    }

    @Override
    public void addTVShowContributor(TVShow tvShow, Contributor contributor, ContributorType contributorType) {
        tvShow.getTvShowContributors().add(newTVShowContributor(tvShow, contributor, contributorType));
    }

    private TVShowContributor newTVShowContributor(TVShow tvShow, Contributor contributor, ContributorType contributorType) {
        return TVShowContributor.builder().tvShow(tvShow).contributor(contributor).contributorType(contributorType).build();
    }

    @Override
    public TVShow findLazy(Long id) {
        return tvShowRepository.findLazy(id);
    }

    @Override
    public List<TVShow> findAllLazy() {
        return tvShowRepository.findAllLazy();
    }
}
