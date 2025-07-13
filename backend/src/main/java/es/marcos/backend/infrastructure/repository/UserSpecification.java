package es.marcos.backend.infrastructure.repository;

import es.marcos.backend.domain.model.UserCriteria;
import es.marcos.backend.infrastructure.repository.entity.UserEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    public static Specification<UserEntity> fromCriteria(UserCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getName() != null) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("name")),
                                "%" + criteria.getName().toLowerCase() + "%"
                        )
                );
            }

            if (criteria.getSurname() != null) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("surname")),
                                "%" + criteria.getSurname().toLowerCase() + "%"
                        )
                );
            }

            if (criteria.getUserState() != null) {
                predicates.add(
                        cb.equal(root.get("userState"), criteria.getUserState())
                );
            }

            if (criteria.getUserRole() != null) {
                predicates.add(
                        cb.equal(root.get("userRole"), criteria.getUserRole())
                );
            }

            if (criteria.getImageConsent() != null) {
                predicates.add(
                        cb.equal(root.get("imageConsent"), criteria.getImageConsent())
                );
            }

            if (criteria.getAcceptsPayment() != null) {
                predicates.add(
                        cb.equal(root.get("acceptPayments"), criteria.getAcceptsPayment())
                );
            }

            if (criteria.getReceivesNotifications() != null) {
                predicates.add(
                        cb.equal(root.get("receivesNotifications"), criteria.getReceivesNotifications())
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
