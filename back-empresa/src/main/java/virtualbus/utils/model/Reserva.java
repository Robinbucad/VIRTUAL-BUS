package virtualbus.utils.model;

import lombok.Data;

@Data
public class Reserva {
    private String reservaId;
    private String ciudadDestino;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correoElectronico;
    private String fecha;
    private int hora;

    private ReservaStatus reservaStatus;
    private String idBus;
}
