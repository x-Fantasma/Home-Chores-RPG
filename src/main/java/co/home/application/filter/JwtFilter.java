package co.home.application.filter;

import co.home.application.dto.jwt.JwtDto;
import co.home.bussines.facade.auth.useCase.IJwtProviderFacade;
import co.home.bussines.facade.auth.useCase.IUserAuthServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Scope("singleton")
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private IJwtProviderFacade provider;

    @Autowired
    private IUserAuthServiceFacade userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var jwt = getToken(request);
        if(jwt != null) {
            provider.validateToken(jwt);
            var userName = provider.getUserNameFromToken(jwt);
            var user = userService.getUserByUserName(userName);

            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }

    public JwtDto getToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer")) {
            var token = header.replace("Bearer ", "");
            return new JwtDto(token);
        }else return null;
    }
}
