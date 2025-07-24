/*package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.UpdateUserRequest;
import es.marcos.backend.domain.exception.UserNotFoundException;
import es.marcos.backend.domain.model.User;
import es.marcos.backend.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers_shouldReturnPage() {
        User user = new User();
        Page<User> page = new PageImpl<>(List.of(user));

        when(repository.findAll(any(Pageable.class))).thenReturn(page);

        Page<User> result = userService.getAllUsers(Pageable.unpaged());

        assertThat(result).isNotNull();
        assertThat(result.getContent()).hasSize(1);
    }

    @Test
    void getAllUsers_shouldReturnEmptyPage_whenNoUsers() {
        Page<User> emptyPage = Page.empty();

        when(repository.findAll(any(Pageable.class))).thenReturn(emptyPage);

        Page<User> result = userService.getAllUsers(Pageable.unpaged());

        assertThat(result).isNotNull();
        assertThat(result.getContent()).isEmpty();
    }


    @Test
    void getUserById_shouldReturnUser_whenExists() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(repository.findById(userId)).thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserById(userId);

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(userId);
    }

    @Test
    void getUserById_shouldReturnEmpty_whenNotExists() {
        Long userId = 2L;

        when(repository.findById(userId)).thenReturn(Optional.empty());

        Optional<User> result = userService.getUserById(userId);

        assertThat(result).isEmpty();
    }

    @Test
    void create_shouldSaveUser() {
        User user = new User();

        userService.create(user);

        verify(repository).save(user);
    }

    @Test
    void create_shouldSaveExactUserReference() {
        User user = new User();

        userService.create(user);

        verify(repository).save(same(user));
    }


    @Test
    void delete_shouldDelete_whenUserExists() {
        Long userId = 3L;
        User user = new User();
        when(repository.findById(userId)).thenReturn(Optional.of(user));

        userService.delete(userId);

        verify(repository).delete(user);
    }

    @Test
    void delete_shouldThrow_whenUserDoesNotExist() {
        Long userId = 4L;
        when(repository.findById(userId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.delete(userId))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining("4");
    }

    @Test
    void update_shouldThrow_whenUserNotFound() {
        Long userId = 5L;
        UpdateUserRequest request = new UpdateUserRequest();

        when(repository.findById(userId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.update(userId, request))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining("5");
    }

    @Test
    void update_shouldThrow_whenNoChangesProvided() {
        Long userId = 6L;
        User user = new User();
        UpdateUserRequest request = new UpdateUserRequest(); // todo null

        when(repository.findById(userId)).thenReturn(Optional.of(user));

        assertThatThrownBy(() -> userService.update(userId, request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No fields provided");
    }

    @Test
    void update_shouldUpdateOnlyEmail() {
        Long userId = 10L;
        User user = new User();
        user.setId(userId);
        user.setEmail("old@example.com");

        UpdateUserRequest request = new UpdateUserRequest();
        request.setEmail("new@example.com");

        when(repository.findById(userId)).thenReturn(Optional.of(user));

        userService.update(userId, request);

        assertThat(user.getEmail()).isEqualTo("new@example.com");
        verify(repository).save(user);
    }

    @Test
    void update_shouldIgnoreNullFields() {
        Long userId = 11L;
        User user = new User();
        user.setId(userId);
        user.setName("Original Name");

        UpdateUserRequest request = new UpdateUserRequest();
        request.setEmail("updated@example.com");
        request.setName(null);

        when(repository.findById(userId)).thenReturn(Optional.of(user));

        userService.update(userId, request);

        assertThat(user.getName()).isEqualTo("Original Name");
        assertThat(user.getEmail()).isEqualTo("updated@example.com");

        verify(repository).save(user);
    }


    @Test
    void update_shouldUpdateFields_andSave() {
        Long userId = 7L;
        User user = new User();
        user.setId(userId);
        user.setName("Old Name");

        UpdateUserRequest request = new UpdateUserRequest();
        request.setName("New Name");
        request.setEmail("new@example.com");

        when(repository.findById(userId)).thenReturn(Optional.of(user));

        userService.update(userId, request);

        assertThat(user.getName()).isEqualTo("New Name");
        assertThat(user.getEmail()).isEqualTo("new@example.com");

        verify(repository).save(user);
    }

    @Test
    void update_shouldUpdateRoleAndState() {
        Long userId = 12L;
        User user = new User();
        user.setId(userId);
        user.setUserRole(null);
        user.setUserState(null);

        UpdateUserRequest request = new UpdateUserRequest();
        request.setUserRole(es.marcos.backend.domain.enums.UserRole.ADMIN);
        request.setUserState(es.marcos.backend.domain.enums.UserState.INACTIVE);

        when(repository.findById(userId)).thenReturn(Optional.of(user));

        userService.update(userId, request);

        assertThat(user.getUserRole()).isEqualTo(es.marcos.backend.domain.enums.UserRole.ADMIN);
        assertThat(user.getUserState()).isEqualTo(es.marcos.backend.domain.enums.UserState.INACTIVE);

        verify(repository).save(user);
    }
}*/
