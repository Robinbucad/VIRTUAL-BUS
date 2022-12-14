package virtualbus.reserva.application;

import virtualbus.reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import virtualbus.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.List;

public interface ReservaService {


    List<ReservaOutputDTO> getAllReservas(String token);

    String postReserva(ReservaInputDTO reservaInputDTO, String idBus);

    List<ReservaOutputDTO> getReservasList(String id_bus);

    String cancelReserva(String id_reserva);

}
