package co.home.bussines.facade.auth.useCase;

import co.home.application.dto.jwt.JwtDto;
import co.home.application.dto.user.UserCredentialsDto;
import co.home.application.dto.user.UserDto;

public interface IAuthServiceFacade {

    void register(UserDto userRequest);
    JwtDto login(UserCredentialsDto user);
}
