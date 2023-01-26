package ch.martinelli.demo.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
@DataJpaTest
class PersonBaseJpaRepositoryTest {

    @Autowired
    private PersonBaseJpaRepository repository;

    @Test
    void persist(CapturedOutput output) {
        Person peter = new Person("Peter");
        repository.persistAndFlush(peter);

        assertThat(output).doesNotContain("Hibernate: select ");
    }

    @Test
    void merge(CapturedOutput output) {
        Person peter = new Person("Peter");
        repository.mergeAndFlush(peter);

        assertThat(output).contains("Hibernate: select ");
    }
}
