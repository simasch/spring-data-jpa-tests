package ch.martinelli.demo.jpa;

import io.hypersistence.utils.spring.repository.BaseJpaRepository;

import java.util.UUID;

public interface PersonBaseJpaRepository extends BaseJpaRepository<Person, UUID> {
}
