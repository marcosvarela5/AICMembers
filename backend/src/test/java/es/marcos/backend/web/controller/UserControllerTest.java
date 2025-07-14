package es.marcos.backend.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.marcos.backend.application.dto.UpdateUserRequest;
import es.marcos.backend.application.service.UserService;
import es.marcos.backend.domain.exception.UserNotFoundException;
import es.marcos.backend.domain.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllUsers_shouldReturnOkWithUsers() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Marcos");

        Page<User> page = new PageImpl<>(List.of(user));

        Mockito.when(userService.getAllUsers(any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1L))
                .andExpect(jsonPath("$.content[0].name").value("Marcos"));
    }

    @Test
    void getUserById_shouldReturnOk_whenExists() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Marcos");

        Mockito.when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Marcos"));
    }

    @Test
    void getUserById_shouldReturnNotFound_whenNotExists() throws Exception {
        Mockito.when(userService.getUserById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void patchUser_shouldReturnNoContent_whenValidRequest() throws Exception {
        UpdateUserRequest request = new UpdateUserRequest();
        request.setName("Nuevo nombre");

        mockMvc.perform(patch("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNoContent());

        verify(userService).update(eq(1L), any(UpdateUserRequest.class));
    }

    @Test
    void deleteUser_shouldReturnNoContent() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());

        verify(userService).delete(1L);
    }

    @Test
    void getUserById_shouldReturnErrorResponse_whenUserNotFound() throws Exception {
        Long userId = 5L;

        Mockito.when(userService.getUserById(userId))
                .thenThrow(new UserNotFoundException("No se encontró el usuario con id " + userId));

        mockMvc.perform(get("/api/users/{id}", userId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("No se encontró el usuario con id " + userId))
                .andExpect(jsonPath("$.path").value("/api/users/5"))
                .andExpect(jsonPath("$.timestamp").exists());
    }


}
