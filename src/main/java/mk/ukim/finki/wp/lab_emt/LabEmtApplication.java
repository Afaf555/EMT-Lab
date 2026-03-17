package mk.ukim.finki.wp.lab_emt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LabEmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabEmtApplication.class, args);
    }

}
