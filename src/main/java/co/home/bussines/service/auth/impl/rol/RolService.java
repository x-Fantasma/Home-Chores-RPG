package co.home.bussines.service.auth.impl.rol;

import co.home.bussines.adapters.mapperEntity.RolMapperEntity;
import co.home.bussines.model.rol.Rol;
import co.home.transversal.model.Role;
import co.home.bussines.repository.IRolRepository;
import co.home.bussines.service.auth.useCase.rol.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService implements IRolService {

    @Autowired
    private IRolRepository repository;

    @Autowired
    private RolMapperEntity mapper;


    @Override
    public Rol findByRol(Role role) {
        var rol = repository.findByRol(role);
        return mapper.toDomain(rol);
    }
}
