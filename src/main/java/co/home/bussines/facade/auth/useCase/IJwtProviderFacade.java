package co.home.bussines.facade.auth.useCase;

import co.home.application.dto.jwt.JwtDto;

public interface IJwtProviderFacade {

    String getUserNameFromToken(JwtDto jwt);
    void validateToken(JwtDto jwt);
}
