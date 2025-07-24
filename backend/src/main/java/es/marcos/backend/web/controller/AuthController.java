package es.marcos.backend.web.controller;

import es.marcos.backend.application.dto.UserRegistrationCommand;
import es.marcos.backend.application.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRegistrationService userRegistrationService;

    public AuthController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody UserRegistrationCommand command) {
        userRegistrationService.register(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
