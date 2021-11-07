package co.home.bussines.facade.auth.impl;


import co.home.application.dto.jwt.JwtDto;
import co.home.application.dto.user.UserCredentialsDto;
import co.home.application.dto.user.UserDto;
import co.home.bussines.adapters.mapperDto.JwtMapperDto;
import co.home.bussines.adapters.mapperDto.UserMapperDto;
import co.home.bussines.facade.auth.useCase.IAuthServiceFacade;
import co.home.bussines.service.auth.useCase.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceFacade implements IAuthServiceFacade {

    @Autowired
    private UserMapperDto userMapperDto;

    @Autowired
    private JwtMapperDto jwtMapper;

    @Autowired
    private IAuthService service;

    @Override
    public void register(UserDto userRequest) {
        service.register(userMapperDto.toDomain(userRequest));
    }

    @Override
    public JwtDto login(UserCredentialsDto user) {
        var jwToken = service.login(userMapperDto.toDomain(user));
        return jwtMapper.toDto(jwToken);
    }
}
