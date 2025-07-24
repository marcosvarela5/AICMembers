package es.marcos.backend.application.mapper;

import es.marcos.backend.application.dto.UserDto;
import es.marcos.backend.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setDni(user.getDni());
        dto.setBirthDate(user.getBirthDate());
        dto.setAddress(user.getAddress());
        dto.setZipCode(user.getZipCode());
        dto.setTown(user.getTown());
        dto.setProvince(user.getProvince());
        dto.setTelephone(user.getTelephone());
        dto.setMobilePhone(user.getMobilePhone());
        dto.setEmail(user.getEmail());
        dto.setBankName(user.getBankName());
        dto.setIban(user.getIban());
        dto.setReceivesNotifications(user.getReceivesNotifications());
        dto.setImageConsent(user.getImageConsent());
        dto.setAcceptPayments(user.getAcceptPayments());
        dto.setUserRole(user.getUserRole().name());
        dto.setUserState(user.getUserState().name());
        dto.setRegisterDate(user.getRegisterDate().toLocalDate());
        dto.setRemoveDate(user.getRemoveDate() != null ? user.getRemoveDate().toLocalDate() : null);
        return dto;
    }

}
