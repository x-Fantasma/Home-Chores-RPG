package co.home.bussines.adapters.mapperEntity;

import co.home.bussines.model.user.User;
import co.home.infrastructure.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Scope("singleton")
@Component
public class UserMapperEntity {

    @Autowired
    private RolMapperEntity rolMapperEntity;

    public User toDomain(UserEntity entity) {
        return User.build(
                entity.getId(),
                entity.getName(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getBirthDay(),
                entity.getRoles().stream().map(rolEntity -> rolMapperEntity.toDomain(rolEntity)).collect(Collectors.toSet()));
    }

    public UserEntity toEntity(User user) {
        var entity = UserEntity.builder()
                .name(user.getName())
                .username(user.getUserName())
                .password(user.getPassword())
                .birthDay(user.getBirthDay())
                .roles(user.getRoles().stream().map(rol -> rolMapperEntity.toEntity(rol)).collect(Collectors.toSet()));

        if(!Objects.isNull(user.getId()))
            entity.id(user.getId());

        return entity.build();
    }

}
