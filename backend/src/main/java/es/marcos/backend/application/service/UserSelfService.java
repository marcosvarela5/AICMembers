package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.UpdateUserRequest;
import es.marcos.backend.domain.model.User;

import java.util.Optional;

public interface UserSelfService {

    Optional<User> getOwnUser(Long id);
    void updateOwnData(Long id, UpdateUserRequest request);
}
