package co.home.bussines.facade.auth.impl.jwt;

import co.home.application.dto.jwt.JwtDto;
import co.home.bussines.adapters.mapperDto.JwtMapperDto;
import co.home.bussines.facade.auth.useCase.IJwtProviderFacade;
import co.home.bussines.service.auth.useCase.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JwtProviderFacade implements IJwtProviderFacade {

    @Autowired
    private IJwtProvider provider;

    @Autowired
    private JwtMapperDto mapper;


    @Override
    public String getUserNameFromToken(JwtDto jwt) {
        return provider.getUserNameFromToken(mapper.toDomain(jwt));
    }

    @Override
    public void validateToken(JwtDto jwt) {
        provider.validateToken(mapper.toDomain(jwt));
    }
}
