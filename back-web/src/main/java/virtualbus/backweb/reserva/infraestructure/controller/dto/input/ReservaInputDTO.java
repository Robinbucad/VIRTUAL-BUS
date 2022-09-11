package virtualbus.backweb.reserva.infraestructure.controller.dto.input;

import lombok.Data;
import virtualbus.backweb.reserva.domain.ReservaStatus;

@Data
public class ReservaInputDTO {

    private String reservaId;
    private String idBus;
    private String ciudadDestino;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correoElectronico;
    private String fecha;
    private int dia;
    private ReservaStatus reservaStatus = ReservaStatus.PENDIENTE;
}
