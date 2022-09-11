package virtualbus.backempresa.bus.application;

import org.apache.kafka.common.protocol.types.Field;
import virtualbus.backempresa.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.backempresa.bus.infraestructure.controller.dto.output.BusOutputDTO;

import java.util.List;


public interface BusService {
    BusOutputDTO createBus(BusInputDTO bus);

    BusOutputDTO getBusById(String id);

    String checkPlazas(String id);

    List<BusOutputDTO> getBuses();
}
