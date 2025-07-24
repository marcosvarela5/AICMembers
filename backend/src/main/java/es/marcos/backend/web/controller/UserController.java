package es.marcos.backend.web.controller;

import es.marcos.backend.application.dto.UpdateUserRequest;
import es.marcos.backend.application.dto.UserDto;
import es.marcos.backend.application.mapper.UserMapper;
import es.marcos.backend.application.service.UserAdministrationService;
import es.marcos.backend.application.service.UserSelfService;
import es.marcos.backend.domain.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserSelfService userSelfService;
    private final UserAdministrationService userAdministrationService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;


    public UserController(UserSelfService userSelfService,
                          UserAdministrationService userAdministrationService,
                          UserMapper userMapper,
                          UserRepository userRepository) {
        this.userSelfService = userSelfService;
        this.userAdministrationService = userAdministrationService;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @GetMapping
    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return userSelfService.getOwnUser(id)
                .map(userMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request) {
        userSelfService.updateOwnData(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userAdministrationService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
