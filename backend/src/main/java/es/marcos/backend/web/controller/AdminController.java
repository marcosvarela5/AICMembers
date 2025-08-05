package es.marcos.backend.web.controller;

import es.marcos.backend.application.dto.UserDto;
import es.marcos.backend.application.service.UserAdministrationService;
import es.marcos.backend.domain.enums.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserAdministrationService userAdministrationService;

    public AdminController(UserAdministrationService userAdministrationService) {
        this.userAdministrationService = userAdministrationService;
    }

    @PostMapping("/approve/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> approve(@PathVariable Long id) {
        userAdministrationService.approve(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pending")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<UserDto>> getPendingUsers(Pageable pageable) {
        Page<UserDto> pendingUsers = userAdministrationService.getPendingUsers(pageable);
        if (pendingUsers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pendingUsers);
    }

    @DeleteMapping("/reject/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> reject(@PathVariable Long id) {
        userAdministrationService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/promote/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> promoteUser(@PathVariable Long id) {
        userAdministrationService.updateRole(id, UserRole.MODERATOR);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/demote/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> demoteUser(@PathVariable Long id) {
        userAdministrationService.updateRole(id, UserRole.SOCIO);
        return ResponseEntity.ok().build();
    }

}
