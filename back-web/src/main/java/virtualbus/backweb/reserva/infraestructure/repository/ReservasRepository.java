package virtualbus.backweb.reserva.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import virtualbus.backweb.reserva.domain.ReservaEntity;

import java.util.List;

@Repository
public interface ReservasRepository extends JpaRepository<ReservaEntity, String> {
    List<ReservaEntity> findByIdBus(String id_bus);
}
