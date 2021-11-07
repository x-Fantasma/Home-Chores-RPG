package co.home.bussines.adapters.mapperDto;


import co.home.application.dto.jwt.JwtDto;
import co.home.bussines.model.jwt.JwToken;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class JwtMapperDto {

    public JwtDto toDto(JwToken jwToken) {
        return new JwtDto(jwToken.getToken());
    }

    public JwToken toDomain(JwtDto jwt) {
        return JwToken.build(jwt.getToken());
    }

}
