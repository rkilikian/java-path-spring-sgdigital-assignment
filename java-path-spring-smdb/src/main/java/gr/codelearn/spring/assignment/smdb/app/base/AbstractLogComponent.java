package gr.codelearn.spring.assignment.smdb.app.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AbstractLogComponent {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    private void init() {
        logger.trace("Loaded {}.", getClass().getName());
    }

    @PreDestroy
    private void destroy() {
        logger.trace("Ready to destroy {}.", getClass().getName());
    }
}