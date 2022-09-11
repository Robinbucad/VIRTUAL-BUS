package virtualbus.backweb.bus.application;

import virtualbus.backweb.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.backweb.bus.infraestructure.controller.dto.output.BusOutputDTO;

public interface BusService {
    BusOutputDTO createBus(BusInputDTO bus);

    BusOutputDTO getBusById(String id);
}
