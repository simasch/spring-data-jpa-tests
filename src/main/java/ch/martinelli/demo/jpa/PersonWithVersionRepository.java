package ch.martinelli.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonWithVersionRepository extends JpaRepository<PersonWithVersion, UUID> {
}
