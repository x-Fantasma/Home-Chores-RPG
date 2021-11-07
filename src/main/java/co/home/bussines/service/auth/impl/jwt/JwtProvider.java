package co.home.bussines.service.auth.impl.jwt;

import co.home.transversal.exception.ExceptionJwt;
import co.home.transversal.exception.messages.ExceptionMessages;
import co.home.bussines.model.jwt.JwToken;
import co.home.bussines.model.user.UserAuth;
import co.home.bussines.service.auth.useCase.jwt.IJwtProvider;
import com.nimbusds.jwt.JWTParser;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtProvider implements IJwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;


    @Override
    public JwToken generateToken(Authentication authentication) {
        var userAuth = (UserAuth) authentication.getPrincipal();
        var token = getToken(userAuth.getUserName(), userAuth.getAuthorities());
        return JwToken.build(token);
    }

    @Override
    public JwToken refreshToken(JwToken jwToken) {
        try {
            var jwt = JWTParser.parse(jwToken.getToken());
            var claims = jwt.getJWTClaimsSet();
            var userName = claims.getSubject();

            @SuppressWarnings("unchecked")
            var authorities = (Set<GrantedAuthority>) claims.getClaim("roles");

            var token = getToken(userName, authorities);
            return JwToken.build(token);
        }catch (Exception e) {
            throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_INVALID);
        }
    }

    private String getToken(String userName, Collection<? extends GrantedAuthority> authorities) {
        var roles = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        var date = ZonedDateTime.now();

        return Jwts.builder()
                .setSubject(userName)
                .claim("roles", roles)
                .setIssuedAt(Date.from(date.toInstant()))
                .setExpiration(Date.from(date.plusMinutes(expiration).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    @Override
    public String getUserNameFromToken(JwToken jwToken) {
        return Jwts
                .parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(jwToken.getToken()).getBody()
                .getSubject();
    }

    @Override
    public void validateToken(JwToken jwToken) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(jwToken.getToken());

        }catch (MalformedJwtException e) {
            throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_MALFORMED);
        }catch (ExpiredJwtException e) {
            throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_EXPIRED);
        }catch (UnsupportedJwtException e) {
            throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_UNSOPPORTED);
        }catch (IllegalArgumentException e) {
            throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_EMPTY);
        }catch (SignatureException e) {
            throw new ExceptionJwt(ExceptionMessages.MESSAGE_BADLY_SIGNED_TOKEN);
        }catch (Exception e) {
            throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_INVALID);
        }
    }
}
