package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface UserLoginService {
    public String login(LoginRequest request);
}
