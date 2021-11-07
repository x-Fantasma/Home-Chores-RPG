package co.home.application.dto.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

public class UserAuthDto extends UserDataDto {

    private static final long serialVersionUID = 1L;

    private Set<? extends GrantedAuthority> authorities;

    public UserAuthDto(String userName, String password, String name, String birthDay, Set<? extends GrantedAuthority> authorities) {
        super(userName, password, name, birthDay);
        this.authorities = authorities;
    }

    public Set<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
