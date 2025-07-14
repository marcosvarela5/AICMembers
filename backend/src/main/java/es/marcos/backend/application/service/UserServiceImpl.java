package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.UpdateUserRequest;
import es.marcos.backend.domain.exception.UserNotFoundException;
import es.marcos.backend.domain.model.User;
import es.marcos.backend.domain.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }


    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public void update(Long id, UpdateUserRequest request) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        boolean hasChanges = false;

        if (request.getName() != null) {
            user.setName(request.getName());
            hasChanges = true;
        }
        if (request.getSurname() != null) {
            user.setSurname(request.getSurname());
            hasChanges = true;
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
            hasChanges = true;
        }
        if (request.getMobilePhone() != null) {
            user.setMobilePhone(request.getMobilePhone());
            hasChanges = true;
        }
        if (request.getTelephone() != null) {
            user.setTelephone(request.getTelephone());
            hasChanges = true;
        }
        if (request.getAddress() != null) {
            user.setAddress(request.getAddress());
            hasChanges = true;
        }
        if (request.getZipCode() != null) {
            user.setZipCode(request.getZipCode());
            hasChanges = true;
        }
        if (request.getTown() != null) {
            user.setTown(request.getTown());
            hasChanges = true;
        }
        if (request.getProvince() != null) {
            user.setProvince(request.getProvince());
            hasChanges = true;
        }
        if (request.getBankName() != null) {
            user.setBankName(request.getBankName());
            hasChanges = true;
        }
        if (request.getIban() != null) {
            user.setIban(request.getIban());
            hasChanges = true;
        }
        if (request.getReceivesNotifications() != null) {
            user.setReceivesNotifications(request.getReceivesNotifications());
            hasChanges = true;
        }
        if (request.getImageConsent() != null) {
            user.setImageConsent(request.getImageConsent());
            hasChanges = true;
        }
        if (request.getAcceptPayments() != null) {
            user.setAcceptPayments(request.getAcceptPayments());
            hasChanges = true;
        }
        if (request.getUserRole() != null) {
            user.setUserRole(request.getUserRole());
            hasChanges = true;
        }
        if (request.getUserState() != null) {
            user.setUserState(request.getUserState());
            hasChanges = true;
        }

        if (!hasChanges) {
            throw new IllegalArgumentException("No fields provided for update.");
        }

        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        repository.delete(user);
    }
}
