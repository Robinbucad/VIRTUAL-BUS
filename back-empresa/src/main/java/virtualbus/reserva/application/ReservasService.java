package virtualbus.reserva.application;

import virtualbus.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.List;

public interface ReservasService {
    List<ReservaOutputDTO> reservasRealizadasBusHoraDiaHoraDestino( String id_bus,String dia, int hora, String destino);
}
