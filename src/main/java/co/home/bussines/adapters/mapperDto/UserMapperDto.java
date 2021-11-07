package co.home.bussines.adapters.mapperDto;

import co.home.application.dto.user.UserCredentialsDto;
import co.home.application.dto.user.UserDto;
import co.home.bussines.model.rol.Rol;
import co.home.bussines.model.user.User;
import co.home.bussines.model.user.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Scope("singleton")
@Component
public class UserMapperDto {

    @Autowired
    private PasswordEncoder encoder;

    public User toDomain(UserDto userDto) {
        return User.build(
                userDto.getName(),
                userDto.getUsername(),
                encoder.encode(userDto.getPassword()),
                LocalDate.parse(userDto.getBirthDay(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                userDto.getRoles().stream().map(Rol::build).collect(Collectors.toSet())
        );
    }

    public UserCredentials toDomain(UserCredentialsDto user) {
        return UserCredentials.build(user.getUsername(), user.getPassword());
    }
}
