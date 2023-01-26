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
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Test
    void save(CapturedOutput output) {
        Person peter = new Person("Peter");
        repository.saveAndFlush(peter);

        assertThat(output).contains("Hibernate: select ");
    }
}
