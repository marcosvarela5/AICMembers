package es.marcos.backend.infrastructure.mapper;

import es.marcos.backend.domain.model.User;
import es.marcos.backend.infrastructure.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getDni(),
                entity.getPassword(),
                entity.getBirthDate(),
                entity.getAddress(),
                entity.getZipCode(),
                entity.getTown(),
                entity.getProvince(),
                entity.getTelephone(),
                entity.getMobilePhone(),
                entity.getEmail(),
                entity.getBankName(),
                entity.getIban(),
                entity.getReceivesNotifications(),
                entity.getImageConsent(),
                entity.getAcceptPayments(),
                entity.getRegisterDate(),
                entity.getRemoveDate(),
                entity.getUserState(),
                entity.getUserRole()
        );
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getDni(),
                user.getPassword(),
                user.getBirthDate(),
                user.getAddress(),
                user.getZipCode(),
                user.getTown(),
                user.getProvince(),
                user.getTelephone(),
                user.getMobilePhone(),
                user.getEmail(),
                user.getBankName(),
                user.getIban(),
                user.getReceivesNotifications(),
                user.getImageConsent(),
                user.getAcceptPayments(),
                user.getRegisterDate(),
                user.getRemoveDate(),
                user.getUserState(),
                user.getUserRole()
        );
    }
}
