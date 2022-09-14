package virtualbus.backempresa.persona.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import virtualbus.backempresa.persona.domain.PersonaEntity;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity,Long> {
    Optional<PersonaEntity> findByUsername(String username);

}
