package co.home.bussines.facade.auth.useCase;

import co.home.application.dto.user.UserAuthDto;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface IUserAuthServiceFacade {

    UserAuthDto getUserByUserName(String username);
    void configure(AuthenticationManagerBuilder auth, PasswordEncoder encoder) throws Exception;
}
