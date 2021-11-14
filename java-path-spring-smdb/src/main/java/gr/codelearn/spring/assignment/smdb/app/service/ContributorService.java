package gr.codelearn.spring.assignment.smdb.app.service;

import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;

import java.util.List;

public interface ContributorService extends BaseService<Contributor, Long> {
    Contributor findByFullName(final String name);

    Contributor findLazy(Long id);

    List<Contributor> findByFirstName(final String firstName);

    List<Contributor> findByLastName(final String lastName);

    List<Contributor> findAllLazy();
}
