package virtualbus.backempresa.bus.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import virtualbus.backempresa.bus.domain.BusEntity;

import java.util.List;
import java.util.Optional;

public interface BusRepository extends JpaRepository<BusEntity,String> {
     Optional<BusEntity> findBusByIdBus(String idBus);
    Optional<BusEntity> findBusByHora(int hora);
}
