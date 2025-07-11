package es.marcos.backend.domain.repository;

import es.marcos.backend.domain.enums.SocioState;
import es.marcos.backend.domain.model.Socio;
import es.marcos.backend.domain.model.SocioCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SocioRepository {

    void save(Socio socio);

    List<Socio> findAll(Pageable pageable);

    Optional<Socio> findById(Long id);

    Optional<Socio> findByName(String name);

    void delete(Socio socio);

    void deleteById(Long id);

    List<Socio> findByState(SocioState state);

    boolean existsById(Long id);

    boolean existsByName(String name);

    Page<Socio> findByCriteria(SocioCriteria criteria, Pageable pageable);
}
