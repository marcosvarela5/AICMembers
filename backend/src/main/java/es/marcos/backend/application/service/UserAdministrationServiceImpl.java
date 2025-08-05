package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.UserDto;
import es.marcos.backend.application.mapper.UserMapper;
import es.marcos.backend.domain.enums.UserRole;
import es.marcos.backend.domain.enums.UserState;
import es.marcos.backend.domain.exception.UserAlreadyActiveException;
import es.marcos.backend.domain.exception.UserNotFoundException;
import es.marcos.backend.domain.model.User;
import es.marcos.backend.domain.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserAdministrationServiceImpl implements UserAdministrationService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public UserAdministrationServiceImpl(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(userMapper::toDto);
    }

    @Override
    public void approve(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));

        if (user.getUserState() == UserState.ACTIVE) {
            throw new UserAlreadyActiveException("User is already active");
        }

        user.setUserState(UserState.ACTIVE);
        user.setUserRole(UserRole.SOCIO);
        repository.save(user);
    }


    @Override
    public void deactivate(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));

        if (user.getUserState() == UserState.ACTIVE) {
            user.setUserState(UserState.INACTIVE);
            repository.save(user);
        }
    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        repository.delete(user);

    }

    @Override
    public Page<UserDto> getPendingUsers(Pageable pageable) {
        return repository.findByUserState(UserState.PENDING, pageable).map(userMapper::toDto);
    }

    @Override
    public void updateRole(Long id, UserRole role) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setUserRole(role);
        repository.save(user);
    }
}

