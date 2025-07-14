package es.marcos.backend.application.service;

import es.marcos.backend.application.dto.UserRegistrationCommand;

public interface UserRegistrationService {
    void register(UserRegistrationCommand command);
}
