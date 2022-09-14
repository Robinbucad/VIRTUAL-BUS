package virtualbus.reservaDIsponible.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import virtualbus.reservaDIsponible.domain.ReservaDisponibleEntity;

import java.util.Optional;

public interface ReservasDisponiblesRepository extends JpaRepository<ReservaDisponibleEntity, String> {
    Optional<ReservaDisponibleEntity> findReservaDisponibleByIdBus(String idBus);
}
