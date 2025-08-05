package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.UserRegistrationCommand;
import es.marcos.backend.domain.enums.UserRole;
import es.marcos.backend.domain.enums.UserState;
import es.marcos.backend.domain.model.User;
import es.marcos.backend.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegistrationCommand command) {

        boolean exists = repository.existsByEmail(command.getEmail().toLowerCase());
        if (exists) {
            throw new IllegalArgumentException("El email ya está registrado.");
        }

        String hashedPassword = passwordEncoder.encode(command.getPassword());


        User user = new User(
                null,
                command.getName(),
                command.getSurname(),
                command.getDni(),
                hashedPassword,
                command.getBirthDate(),
                command.getAddress(),
                command.getZipCode(),
                command.getTown(),
                command.getProvince(),
                command.getTelephone(),
                command.getMobilePhone(),
                command.getEmail().toLowerCase(),
                command.getBankName(),
                command.getIban(),
                command.getReceivesNotifications(),
                command.getImageConsent(),
                command.getAcceptPayments(),
                LocalDateTime.now(), // fecha de alta
                null,                // fecha de baja
                UserState.PENDING,
                UserRole.ASPIRANTE
        );

        // 3. Guardar el usuario
        repository.save(user);
    }
}
