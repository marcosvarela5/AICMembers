package es.marcos.backend.infrastructure.repository;

import es.marcos.backend.domain.enums.UserRole;
import es.marcos.backend.domain.enums.UserState;
import es.marcos.backend.domain.model.User;
import es.marcos.backend.domain.model.UserCriteria;
import es.marcos.backend.domain.repository.UserRepository;
import es.marcos.backend.infrastructure.mapper.UserEntityMapper;
import es.marcos.backend.infrastructure.repository.specification.UserSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryJpa implements UserRepository {



    private final SpringDataUserRepository springDataRepo;
    private final UserEntityMapper mapper;

    public UserRepositoryJpa(SpringDataUserRepository springDataRepo, UserEntityMapper mapper) {
        this.springDataRepo = springDataRepo;
        this.mapper = mapper;
    }

    @Override
    public void save(User user) {
        springDataRepo.save(mapper.toEntity(user));
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return springDataRepo.findAll(pageable)
                .map(mapper::toDomain);
    }


    @Override
    public Optional<User> findById(Long id) {
        return springDataRepo.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByDni(String dni) {
        return springDataRepo.findByDni(dni).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByName(String name) {
        return springDataRepo.findByName(name).map(mapper::toDomain);
    }

    @Override
    public void delete(User user) {
        springDataRepo.delete(mapper.toEntity(user));
    }

    @Override
    public void deleteById(Long id) {
        springDataRepo.deleteById(id);
    }

    @Override
    public Page<User> findByUserState(UserState state, Pageable pageable) {
        return springDataRepo.findByUserState(state, pageable)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springDataRepo.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return springDataRepo.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataRepo.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return springDataRepo.existsByName(name);
    }

    @Override
    public Page<User> findByCriteria(UserCriteria criteria, Pageable pageable) {
        return springDataRepo.findAll(
                UserSpecification.fromCriteria(criteria),
                pageable
        ).map(mapper::toDomain);
    }


    @Override
    public Page<User> findByUserRole(UserRole role, Pageable pageable) {
        return null;
    }
}
