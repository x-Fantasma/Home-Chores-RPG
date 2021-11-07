package co.home.bussines.repository;

import co.home.transversal.model.Role;
import co.home.infrastructure.repository.entity.RolEntity;

public interface IRolRepository {

    RolEntity findByRol(Role rol);
}
