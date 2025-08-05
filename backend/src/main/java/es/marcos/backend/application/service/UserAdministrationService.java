package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.UserDto;
import es.marcos.backend.domain.enums.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserAdministrationService {

    Page<UserDto> getAll(Pageable pageable);
    void approve(Long id);
    void deactivate(Long id);
    void delete(Long id);
    Page<UserDto> getPendingUsers(Pageable pageable);
    void updateRole(Long id, UserRole role);
}
