package gr.codelearn.spring.assignment.smdb.app.service;

import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;

public interface ContributorService extends BaseService<Contributor, Long> {
    Contributor findByFullName(final String name);

    //Contributor findLazy(Long id);
}
