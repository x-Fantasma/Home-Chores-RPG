package co.home.bussines.service.auth.impl.user;

import co.home.bussines.model.user.UserAuth;
import co.home.bussines.service.auth.useCase.user.IUserAuthService;
import co.home.bussines.service.auth.useCase.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements IUserAuthService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = userService.findByUsername(username);
        return UserAuth.build(user);
    }
}
