package ch.martinelli.demo.jpa;

import io.hypersistence.utils.spring.repository.BaseJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
        value = "ch.martinelli.demo.jpa",
        repositoryBaseClass = BaseJpaRepositoryImpl.class
)
public class SpringDataJpaTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaTestsApplication.class, args);
    }

}
