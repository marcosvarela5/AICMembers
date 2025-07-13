package es.marcos.backend.infrastructure.repository;

import es.marcos.backend.domain.enums.UserRole;
import es.marcos.backend.domain.enums.UserState;
import es.marcos.backend.infrastructure.repository.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface SpringDataUserRepository
        extends JpaRepository<UserEntity, Long>,
        JpaSpecificationExecutor<UserEntity> {

    Optional<UserEntity> findByName(String name);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByDni(String dni);

    boolean existsByName(String name);

    boolean existsByEmail(String email);

    Page<UserEntity> findByUserState(UserState state, Pageable pageable);

    Page<UserEntity> findByUserRole(UserRole role, Pageable pageable);
}
