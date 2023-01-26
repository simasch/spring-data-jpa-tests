package ch.martinelli.demo.jpa;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
@DataJpaTest
class PersonWithVersionRepositoryTest {

    @Autowired
    private PersonWithVersionRepository repository;
    @Autowired
    private EntityManager em;

    @Test
    void save(CapturedOutput output) {
        PersonWithVersion peter = new PersonWithVersion("Peter");
        repository.saveAndFlush(peter);

        assertThat(output).doesNotContain("Hibernate: select ");
    }

    @Test
    void persist(CapturedOutput output) {
        PersonWithVersion peter = new PersonWithVersion("Peter");
        em.persist(peter);
        em.flush();

        assertThat(output).doesNotContain("Hibernate: select ");
    }

    @Test
    void merge(CapturedOutput output) {
        PersonWithVersion peter = new PersonWithVersion("Peter");
        em.merge(peter);
        em.flush();

        assertThat(output).doesNotContain("Hibernate: select ");
    }
}
