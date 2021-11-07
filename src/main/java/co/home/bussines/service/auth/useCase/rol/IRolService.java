package co.home.bussines.service.auth.useCase.rol;

import co.home.bussines.model.rol.Rol;
import co.home.transversal.model.Role;

public interface IRolService {

    Rol findByRol(Role rol);
}
