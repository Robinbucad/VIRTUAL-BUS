package virtualbus.bus.application;

import virtualbus.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.bus.infraestructure.controller.dto.output.BusOutputDTO;

import java.util.List;


public interface BusService {
    BusOutputDTO createBus(BusInputDTO bus);

    BusOutputDTO getBusById(String id);

    String checkPlazas(String id);

    List<BusOutputDTO> getBuses();
}
