package co.home.bussines.facade.auth.impl.user;

import co.home.application.dto.user.UserAuthDto;
import co.home.bussines.adapters.mapperDto.UserAuthMapperDto;
import co.home.bussines.facade.auth.useCase.IUserAuthServiceFacade;
import co.home.bussines.model.user.UserAuth;
import co.home.bussines.service.auth.useCase.user.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserAuthServiceFacade implements IUserAuthServiceFacade {

    @Autowired
    private IUserAuthService service;

    @Autowired
    private UserAuthMapperDto userAuthMapper;

    @Override
    public UserAuthDto getUserByUserName(String username) {
        var user = service.loadUserByUsername(username);
        return userAuthMapper.toDto((UserAuth) user);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth, PasswordEncoder encoder) throws Exception {
        auth.userDetailsService(service).passwordEncoder(encoder);
    }
}
