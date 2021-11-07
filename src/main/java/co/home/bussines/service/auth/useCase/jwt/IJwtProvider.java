package co.home.bussines.service.auth.useCase.jwt;

import co.home.bussines.model.jwt.JwToken;
import org.springframework.security.core.Authentication;

public interface IJwtProvider {

    JwToken generateToken(Authentication authentication);
    JwToken refreshToken(JwToken jwToken);
    String getUserNameFromToken(JwToken jwToken);
    void validateToken(JwToken jwToken);
}
