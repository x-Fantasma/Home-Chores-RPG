package co.home.infrastructure.repository.jpa;

import co.home.transversal.model.Role;
import co.home.infrastructure.repository.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepositoryJpa extends JpaRepository<RolEntity, Role> {

    Optional<RolEntity> findByRol(Role rol);
}
