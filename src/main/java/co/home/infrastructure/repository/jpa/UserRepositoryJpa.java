package co.home.infrastructure.repository.jpa;

import co.home.infrastructure.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String userName);
    boolean existsByUsername(String userName);
    void deleteByUsername(String userName);
}
