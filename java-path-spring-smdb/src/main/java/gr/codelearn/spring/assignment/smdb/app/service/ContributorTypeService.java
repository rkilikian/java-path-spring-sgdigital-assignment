package gr.codelearn.spring.assignment.smdb.app.service;

import gr.codelearn.spring.assignment.smdb.app.domain.ContributorType;

public interface ContributorTypeService extends BaseService<ContributorType, Long> {
    ContributorType findByDescription(String description);
}
