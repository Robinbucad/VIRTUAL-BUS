package virtualbus.backempresa.reservas.domain;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ReservaOrder {
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

    public ReservaOrder(){}
}
