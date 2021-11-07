package co.home.bussines.service.auth.impl.user;

import co.home.bussines.adapters.mapperEntity.UserMapperEntity;
import co.home.transversal.exception.ExceptionUser;
import co.home.transversal.exception.messages.ExceptionMessages;
import co.home.bussines.model.user.User;
import co.home.bussines.repository.IUserRepository;
import co.home.bussines.service.auth.useCase.rol.IRolService;
import co.home.bussines.service.auth.useCase.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Autowired
    private IRolService rolService;

    @Autowired
    private UserMapperEntity mapper;

    @Override
    public User findByUsername(String userName) {
        var entity = repository.findByUsername(userName);
        if(!Objects.isNull(entity)) {
            return mapper.toDomain(entity);
        }

        throw new ExceptionUser(ExceptionMessages.MESSAGE_USER_NOT_EXISTING);
    }

    @Override
    public Long saveUser(User user) {
        if(!repository.existsByUsername(user.getUserName())) {
           return repository.saveUser(mapper.toEntity(user)).getId();
        }

        throw new ExceptionUser(ExceptionMessages.MESSAGE_USER_EXISTING);
    }
}
