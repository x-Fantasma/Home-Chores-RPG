package co.home.bussines.adapters.mapperEntity;

import co.home.bussines.model.rol.Rol;
import co.home.infrastructure.repository.entity.RolEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Scope("singleton")
@Component
public class RolMapperEntity {

    public Rol toDomain(RolEntity entity) {
        return Rol.build(entity.getRol());
    }

    public RolEntity toEntity(Rol rol) {
        var entity = RolEntity.builder()
                .rol(rol.getRol());

       /* if(!Objects.isNull(rol.getId()))
            entity.id(rol.getId());*/

        return entity.build();
    }
}
