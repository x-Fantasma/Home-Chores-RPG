package co.home.application.dto.user;

import co.home.transversal.model.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Set;

public class UserDto extends UserDataDto {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Set<Role> roles;

    public UserDto() {
        super();
    }

    public UserDto(String username, String password, String name, String birthDay, Set<Role> roles) {
        super(username, password, name, birthDay);
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
