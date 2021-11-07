package co.home.bussines.model.user;

import co.home.transversal.exception.messages.ExceptionMessages;
import co.home.bussines.model.rol.Rol;
import co.home.transversal.model.Role;
import co.home.bussines.model.validator.ArgumentValidator;

import java.time.LocalDate;
import java.util.Set;

public class User extends UserData {

    private Long id;
    private Set<Rol> roles;

    public User() { }

    private User(String name, String username, String password, LocalDate birthDay, Set<Rol> roles) {
        super(name, username, password, birthDay);
        this.roles = roles;
    }

    private User(Long id, String name, String username, String password, LocalDate birthDay, Set<Rol> roles) {
        super(name, username, password, birthDay);
        this.id = id;
        this.roles = roles;
    }

    public static User build(String name, String username, String password, LocalDate birthDay, Set<Rol> roles) {
        validateArguments(name, username, password);
        validateRoles(roles);

        return new User(name, username, password, birthDay, roles);
    }

    public static User build(Long id, String name, String username, String password, LocalDate birthDay, Set<Rol> roles) {
        validateArguments(name, username, password);
        ArgumentValidator.validateRequired(id, ExceptionMessages.MESSAGE_ID_REQUIRED);
        validateRoles(roles);

        return new User(id, name, username, password, birthDay, roles);
    }

    private static Set<Rol> validateRoles(Set<Rol> roles) {
        roles = (Set<Rol>) ArgumentValidator.getCollectionOrAddDefaultValueToIt(roles, Rol.build(Role.ADVENTURER));
        return roles;
    }

    private static void validateArguments(String name, String username, String password) {
        ArgumentValidator.validateRequired(name, ExceptionMessages.MESSAGE_NAME_REQUIRED);
        ArgumentValidator.validateRequired(username, ExceptionMessages.MESSAGE_USERNAME_REQUIRED);
        ArgumentValidator.validateRequired(password, ExceptionMessages.MESSAGE_PASSWORD_REQUIRED);
    }

    public Long getId() {
        return id;
    }

    public Set<Rol> getRoles() {
        return roles;
    }
}
