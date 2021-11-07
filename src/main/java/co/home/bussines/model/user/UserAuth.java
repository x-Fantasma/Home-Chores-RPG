package co.home.bussines.model.user;

import co.home.transversal.exception.messages.ExceptionMessages;
import co.home.transversal.model.Role;
import co.home.bussines.model.validator.ArgumentValidator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class UserAuth extends UserData implements UserDetails {

    private Set<? extends GrantedAuthority> authorities;

    public UserAuth() { }

    private UserAuth(String name, String username, String password, LocalDate birthDay, Set<? extends GrantedAuthority> authorities) {
        super(name, username, password, birthDay);
        this.authorities = authorities;
    }

    public static UserAuth build(String name, String username, String password, LocalDate birthDay, Set<GrantedAuthority> authorities) {
        ArgumentValidator.validateRequired(name, ExceptionMessages.MESSAGE_NAME_REQUIRED);
        ArgumentValidator.validateRequired(username, ExceptionMessages.MESSAGE_USERNAME_REQUIRED);
        ArgumentValidator.validateRequired(password, ExceptionMessages.MESSAGE_PASSWORD_REQUIRED);
        authorities = (Set<GrantedAuthority>) ArgumentValidator.getCollectionOrAddDefaultValueToIt(authorities, new SimpleGrantedAuthority
                (Role.ADVENTURER.name()));

        return new UserAuth(name, username, password, birthDay, authorities);
    }

    public static UserAuth build(User user) {
        var list = user.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRol().name())).collect(Collectors.toSet());
        return new UserAuth(user.getName(), user.getUserName(), user.getPassword(), user.getBirthDay(), list);
    }


    @Override
    public String getUsername() {
        return this.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
