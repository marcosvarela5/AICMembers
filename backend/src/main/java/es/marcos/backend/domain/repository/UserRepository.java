package es.marcos.backend.domain.repository;

import es.marcos.backend.domain.enums.UserRole;
import es.marcos.backend.domain.enums.UserState;
import es.marcos.backend.domain.model.User;
import es.marcos.backend.domain.model.UserCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Page<User> findAll(Pageable pageable);

    Optional<User> findById(Long id);

    Optional<User> findByDni(String dni);

    Optional<User> findByName(String name);

    void delete(User user);

    void deleteById(Long id);

    Page<User> findByUserState(UserState state, Pageable pageable);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(Long id);

    boolean existsByName(String name);

    Page<User> findByCriteria(UserCriteria criteria, Pageable pageable);

    Page<User> findByUserRole(UserRole role, Pageable pageable);
}
