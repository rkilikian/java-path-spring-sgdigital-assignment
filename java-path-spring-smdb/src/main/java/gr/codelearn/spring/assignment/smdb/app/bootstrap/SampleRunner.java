package gr.codelearn.spring.assignment.smdb.app.bootstrap;

import gr.codelearn.spring.assignment.smdb.app.base.AbstractLogComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner extends AbstractLogComponent implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
    }
}
