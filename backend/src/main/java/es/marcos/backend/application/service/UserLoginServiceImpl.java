package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.LoginRequest;
import es.marcos.backend.domain.model.User;
import es.marcos.backend.domain.repository.UserRepository;
import es.marcos.backend.infrastructure.security.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final JwtService jwtService;

    public UserLoginServiceImpl(AuthenticationManager authenticationManager,
                                UserRepository repository,
                                JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.jwtService = jwtService;
    }

    @Override
    public String login(LoginRequest request) {

        String normalizedEmail = request.getEmail().toLowerCase();

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                normalizedEmail,
                request.getPassword()
        );
        try {
            authenticationManager.authenticate(authentication);
            System.out.println("Autenticación correcta");

            User user = repository.findByEmail(normalizedEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

            return jwtService.generateToken(user);
        } catch (Exception e) {
            System.err.println("Fallo de autenticación: " + e.getMessage());
            throw new BadCredentialsException("Email o contraseña incorrectos");
        }
    }
}
