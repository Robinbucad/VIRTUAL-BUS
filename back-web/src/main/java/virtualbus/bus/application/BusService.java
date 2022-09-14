package virtualbus.bus.application;

import virtualbus.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.bus.infraestructure.controller.dto.output.BusOutputDTO;

public interface BusService {
    BusOutputDTO createBus(BusInputDTO bus);

    BusOutputDTO getBusById(String id);
}
