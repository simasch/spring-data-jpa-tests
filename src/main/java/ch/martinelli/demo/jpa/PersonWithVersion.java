package ch.martinelli.demo.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import java.util.UUID;

@Entity
public class PersonWithVersion {

    @Id
    private UUID uuid = UUID.randomUUID();
    private String name;
    @Version
    private Long version;

    public PersonWithVersion() {
    }

    public PersonWithVersion(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
