package co.home.infrastructure.repository.repo;

import co.home.transversal.model.Role;
import co.home.bussines.repository.IRolRepository;
import co.home.infrastructure.repository.jpa.RolRepositoryJpa;
import co.home.infrastructure.repository.entity.RolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolRepository implements IRolRepository {

    @Autowired
    private RolRepositoryJpa repo;

    @Override
    public RolEntity findByRol(Role rol) {
        return repo.findByRol(rol).orElse(null);
    }
}
