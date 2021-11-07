package co.home.bussines.service.auth.useCase.user;

import co.home.bussines.model.user.User;

public interface IUserService {

    User findByUsername(String userName);
    Long saveUser(User user);
}
