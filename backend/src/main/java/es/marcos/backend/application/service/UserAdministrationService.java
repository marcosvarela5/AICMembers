package es.marcos.backend.application.service;

import es.marcos.backend.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserAdministrationService {

    Page<User> getAll(Pageable pageable);
    void approve(Long id);
    void deactivate(Long id);
    void delete(Long id);
}
