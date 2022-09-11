package virtualbus.backempresa.persona.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import virtualbus.backempresa.persona.domain.PersonaEntity;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity,Long> {
    Optional<PersonaEntity> findByUsername(String username);
    Optional<PersonaEntity> findByEmail(String username);

}
