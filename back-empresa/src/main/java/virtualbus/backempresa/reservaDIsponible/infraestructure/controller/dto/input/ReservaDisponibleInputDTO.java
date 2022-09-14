package virtualbus.backempresa.reservaDIsponible.infraestructure.controller.dto.input;

import lombok.Data;

@Data
public class ReservaDisponibleInputDTO {
    private String idBus;
    private String idReserva;
    private String ciudadDestino;
    private String fechaSalida;
    private int horaSalida;
    private int numeroPlazas;

}
