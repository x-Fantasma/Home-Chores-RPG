package co.home.infrastructure.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "co.home.infrastructure.repository.repo")
public class PersistenceJpa {
}
