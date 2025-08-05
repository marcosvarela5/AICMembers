package es.marcos.backend.web.controller;

import es.marcos.backend.application.dto.AuthenticatedUserDto;
import es.marcos.backend.application.dto.LoginRequest;
import es.marcos.backend.application.dto.LoginResponse;
import es.marcos.backend.application.dto.UserRegistrationCommand;
import es.marcos.backend.application.service.UserLoginService;
import es.marcos.backend.application.service.UserRegistrationService;
import es.marcos.backend.application.service.UserSelfService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRegistrationService userRegistrationService;
    private final UserLoginService userLoginService;
    private final UserSelfService userSelfService;

    public AuthController(UserRegistrationService userRegistrationService, UserLoginService userLoginService, UserSelfService userSelfService) {
        this.userRegistrationService = userRegistrationService;
        this.userLoginService = userLoginService;
        this.userSelfService = userSelfService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody UserRegistrationCommand command) {
        userRegistrationService.register(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = userLoginService.login(request);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @GetMapping("/me")
    public ResponseEntity<AuthenticatedUserDto> getCurrentUser(Authentication authentication) {
        AuthenticatedUserDto dto = userSelfService.getOwnInfo(authentication.getName());
        System.out.println("Usuario autenticado: " + authentication.getName());
        return ResponseEntity.ok(dto);
    }
}
