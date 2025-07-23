package es.marcos.backend.application.service;

import es.marcos.backend.domain.enums.UserState;
import es.marcos.backend.domain.exception.UserNotFoundException;
import es.marcos.backend.domain.model.User;
import es.marcos.backend.domain.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserAdministrationServiceImpl implements UserAdministrationService {

    private final UserRepository repository;

    public UserAdministrationServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void approve(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
        if (user.getUserState() == UserState.ACTIVE) {
            return;
        }
        user.setUserState(UserState.ACTIVE);
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
        return;

    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        repository.delete(user);

    }
}

