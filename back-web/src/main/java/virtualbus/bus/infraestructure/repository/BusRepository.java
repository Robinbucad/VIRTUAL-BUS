package virtualbus.bus.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import virtualbus.bus.domain.BusEntity;

import java.util.Optional;

public interface BusRepository extends JpaRepository<BusEntity,String> {
   Optional<BusEntity> findBusByIdBus(String idBus);

   Optional<BusEntity> findBusByHora(int hora);


}
