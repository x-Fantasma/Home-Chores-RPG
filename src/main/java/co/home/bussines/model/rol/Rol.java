package co.home.bussines.model.rol;

import co.home.transversal.exception.messages.ExceptionMessages;
import co.home.bussines.model.validator.ArgumentValidator;
import co.home.transversal.model.Role;

public class Rol {

    private Role rol;

    public Rol() { }

    private Rol(Role rol) {
        this.rol = rol;
    }

    public static Rol build(Role rol) {
        validateArguments(rol);
        return new Rol(rol);
    }

    private static void validateArguments(Role rol) {
        ArgumentValidator.validateRequired(rol, ExceptionMessages.MESSAGE_ROL_REQUIRED);
    }

    public Role getRol() {
        return rol;
    }
}
