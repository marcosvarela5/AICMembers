package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.AuthenticatedUserDto;
import es.marcos.backend.application.dto.UpdateUserRequest;
import es.marcos.backend.domain.exception.UserNotFoundException;
import es.marcos.backend.domain.model.User;
import es.marcos.backend.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserSelfServiceImpl implements UserSelfService {

    private final UserRepository repository;


    public UserSelfServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> getOwnUser(Long id) {
        return repository.findById(id);
    }

    @Override
    public void updateOwnData(Long id, UpdateUserRequest request) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));

        user.updateFrom(request);
        repository.save(user);
    }

    @Override
    public AuthenticatedUserDto getOwnInfo(String email) {
        User user = repository.findByEmail(email.toLowerCase())
                .orElseThrow(() -> new UserNotFoundException("Usuario non atopado"));

        return new AuthenticatedUserDto(
                user.getName(),
                user.getEmail(),
                user.getUserRole().name()
        );
    }
}
