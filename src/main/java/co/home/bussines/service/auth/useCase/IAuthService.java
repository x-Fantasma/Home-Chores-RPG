package co.home.bussines.service.auth.useCase;

import co.home.bussines.model.jwt.JwToken;
import co.home.bussines.model.user.User;
import co.home.bussines.model.user.UserCredentials;

public interface IAuthService {

    void register(User user);
    JwToken login(UserCredentials userCredentials);
}
