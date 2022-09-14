package virtualbus.reservaDIsponible.application;

import virtualbus.reservaDIsponible.infraestructure.controller.dto.output.ReservaDisponibleOutputDTO;

public interface ReservaDisponibleService {
    String plazasDisponiblesBus(String id_bus,String destino,String dia, int hora);
    ReservaDisponibleOutputDTO createReservaDisponible(String id_bus);
}
