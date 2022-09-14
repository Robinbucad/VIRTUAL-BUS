package virtualbus.model;

import lombok.Data;
import virtualbus.reserva.domain.ReservaStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ReservaInputDto {
    private String reservaId;
    private String ciudadDestino;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correoElectronico;
    private String fecha;
    private int hora;
    @Enumerated(EnumType.STRING)
    private ReservaStatus status;
    private String idBus;
}
