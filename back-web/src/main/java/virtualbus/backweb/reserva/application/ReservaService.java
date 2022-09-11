package virtualbus.backweb.reserva.application;

import virtualbus.backweb.reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaDisponibleOutputDTO;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.List;

public interface ReservaService {


    List<ReservaOutputDTO> getAllReservas(String token);

    String postReserva(ReservaInputDTO reservaInputDTO, String idBus);

    List<ReservaOutputDTO> getReservasList(String id_bus);


}
