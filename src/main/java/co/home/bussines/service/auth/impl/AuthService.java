package co.home.bussines.service.auth.impl;

import co.home.transversal.exception.ExceptionAuth;
import co.home.transversal.exception.messages.ExceptionMessages;
import co.home.bussines.model.jwt.JwToken;
import co.home.bussines.model.user.User;
import co.home.bussines.model.user.UserCredentials;
import co.home.bussines.service.auth.useCase.IAuthService;
import co.home.bussines.service.auth.useCase.jwt.IJwtProvider;
import co.home.bussines.service.auth.useCase.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IJwtProvider provider;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public void register(User user) {
        userService.saveUser(user);
    }

    @Override
    public JwToken login(UserCredentials userCredentials) {
        try {
            var user = new UsernamePasswordAuthenticationToken(userCredentials.getUserName(), userCredentials.getPassword());
            var auth = authenticationManager.authenticate(user);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return provider.generateToken(auth);

        }catch (BadCredentialsException e) {
            throw new ExceptionAuth(ExceptionMessages.MESSAGE_BAD_CREDENTIALS);
        }catch (InternalAuthenticationServiceException e) {
            throw new ExceptionAuth(e.getMessage());
        }
    }
}
