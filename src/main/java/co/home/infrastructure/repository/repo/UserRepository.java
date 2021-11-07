package co.home.infrastructure.repository.repo;

import co.home.bussines.repository.IUserRepository;
import co.home.infrastructure.repository.jpa.UserRepositoryJpa;
import co.home.infrastructure.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements IUserRepository {

    @Autowired
    private UserRepositoryJpa repo;

    @Override
    public UserEntity findByUsername(String userName) {
        return repo.findByUsername(userName).orElse(null);
    }

    @Override
    public boolean existsByUsername(String userName) {
        return repo.existsByUsername(userName);
    }

    @Override
    public void deleteByUsername(String userName) {
        repo.deleteByUsername(userName);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return repo.save(userEntity);
    }
}
