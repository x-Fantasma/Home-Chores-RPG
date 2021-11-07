package co.home.bussines.repository;

import co.home.infrastructure.repository.entity.UserEntity;

public interface IUserRepository {

    UserEntity findByUsername(String userName);
    boolean existsByUsername(String userName);
    void deleteByUsername(String userName);
    UserEntity saveUser(UserEntity userEntity);
}
