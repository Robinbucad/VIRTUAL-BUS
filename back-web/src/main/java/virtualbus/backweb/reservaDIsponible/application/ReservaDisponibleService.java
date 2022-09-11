package virtualbus.backweb.reservaDIsponible.application;

import virtualbus.backweb.reservaDIsponible.infraestructure.controller.dto.input.ReservaDisponibleInputDTO;
import virtualbus.backweb.reservaDIsponible.infraestructure.controller.dto.output.ReservaDisponibleOutputDTO;

public interface ReservaDisponibleService {
    ReservaDisponibleOutputDTO getReservaDisponible(String destino,String dia, int hora);
    ReservaDisponibleOutputDTO createReservaDisponible(String id_bus);
}
