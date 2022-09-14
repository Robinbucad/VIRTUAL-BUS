package virtualbus.bus.infraestructure.controller.dto.input;

import lombok.Data;

@Data
public class BusInputDTO {
    private String idBus;
    private String ciudadSalida;
    private String ciudadDestino;
    private String fecha;
    private int hora;
}
