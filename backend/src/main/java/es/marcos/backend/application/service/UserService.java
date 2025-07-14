package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.UpdateUserRequest;
import es.marcos.backend.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    public Page<User> getAllUsers(Pageable pageable);

    public Optional<User> getUserById(Long id);

    public void create(User user);

    void update(Long id, UpdateUserRequest request);

    public void delete(Long id);
}