package co.home.bussines.adapters.mapperDto;

import co.home.application.dto.user.UserAuthDto;
import co.home.bussines.model.user.UserAuth;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Scope("singleton")
@Component
public class UserAuthMapperDto {

    public UserAuthDto toDto(UserAuth userAuth) {
        return new UserAuthDto(
                userAuth.getUserName(),
                userAuth.getPassword(),
                userAuth.getName(),
                userAuth.getBirthDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                userAuth.getAuthorities()
        );
    }
}
