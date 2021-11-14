package gr.codelearn.spring.assignment.smdb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(namedQueriesLocation = "classpath:jpa-named-queries.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
