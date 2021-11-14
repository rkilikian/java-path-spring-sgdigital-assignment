package gr.codelearn.spring.assignment.smdb.app.service;

import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;
import gr.codelearn.spring.assignment.smdb.app.repository.ContributorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContributorServiceImpl extends BaseServiceImpl<Contributor> implements ContributorService {
    private final ContributorRepository contributorRepository;

    @Override
    public JpaRepository<Contributor, Long> getRepository() {
        return contributorRepository;
    }

    @Override
    public Contributor findByFullName(final String name) {
        return contributorRepository.findAll().stream().filter(c -> c.getFirstName().concat(" " + c.getLastName()).equals(name)).findAny().orElse(null);
    }

    @Override
    public Contributor findLazy(Long id) {
        return contributorRepository.findLazy(id);
    }

    @Override
    public List<Contributor> findAllLazy() {
        return contributorRepository.findAllLazy();
    }
}
