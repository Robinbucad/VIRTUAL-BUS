package virtualbus.backweb.reserva.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import virtualbus.backweb.reserva.domain.ReservaEntity;
import virtualbus.backweb.reserva.domain.ReservaStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservasRepository extends JpaRepository<ReservaEntity, String> {
    List<ReservaEntity> findByIdBus(String id_bus);

    Optional<ReservaEntity> findBycorreoElectronico(String email);
}
