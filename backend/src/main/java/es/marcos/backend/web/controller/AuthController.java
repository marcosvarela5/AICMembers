package es.marcos.backend.web.controller;

import es.marcos.backend.application.dto.LoginRequest;
import es.marcos.backend.application.dto.LoginResponse;
import es.marcos.backend.application.dto.UserRegistrationCommand;
import es.marcos.backend.application.service.UserLoginService;
import es.marcos.backend.application.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRegistrationService userRegistrationService;
    private final UserLoginService userLoginService;

    public AuthController(UserRegistrationService userRegistrationService, UserLoginService userLoginService) {
        this.userRegistrationService = userRegistrationService;
        this.userLoginService = userLoginService;
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
}
