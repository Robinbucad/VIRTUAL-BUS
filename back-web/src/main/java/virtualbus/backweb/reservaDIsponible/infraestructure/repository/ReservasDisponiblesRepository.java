package virtualbus.backweb.reservaDIsponible.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import virtualbus.backweb.reservaDIsponible.domain.ReservaDisponibleEntity;

import java.util.Optional;

public interface ReservasDisponiblesRepository extends JpaRepository<ReservaDisponibleEntity, String> {
    Optional<ReservaDisponibleEntity> findReservaDisponibleByIdBus(String idBus);
}
