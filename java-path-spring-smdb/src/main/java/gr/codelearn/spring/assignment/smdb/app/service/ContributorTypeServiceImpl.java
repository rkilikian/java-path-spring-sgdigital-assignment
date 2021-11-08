package gr.codelearn.spring.assignment.smdb.app.service;

import gr.codelearn.spring.assignment.smdb.app.domain.ContributorType;
import gr.codelearn.spring.assignment.smdb.app.repository.ContributorTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContributorTypeServiceImpl extends BaseServiceImpl<ContributorType> implements ContributorTypeService {
    private final ContributorTypeRepository contributorTypeRepository;

    @Override
    public JpaRepository<ContributorType, Long> getRepository() {
        return contributorTypeRepository;
    }

    @Override
    public ContributorType findByDescription(String description) {
        return contributorTypeRepository.findAll().stream().filter(c -> c.getDescription().equals(description)).findAny().orElse(null);
    }
}
