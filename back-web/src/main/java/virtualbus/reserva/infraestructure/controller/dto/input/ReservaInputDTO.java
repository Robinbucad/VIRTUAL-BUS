package virtualbus.reserva.infraestructure.controller.dto.input;

import lombok.Data;
import virtualbus.bus.domain.BusEntity;
import virtualbus.reserva.domain.ReservaEntity;
import virtualbus.reserva.domain.ReservaStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ReservaInputDTO {

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


    public ReservaInputDTO (ReservaEntity reserva){
        setReservaId(reserva.getReservaId());
        setCiudadDestino(reserva.getCiudadDestino());
        setNombre(reserva.getNombre());
        setApellidos(reserva.getApellidos());
        setTelefono(reserva.getTelefono());
        setCorreoElectronico(reserva.getCorreoElectronico());
        setFecha(reserva.getFecha());
        setHora(reserva.getHora());
        setIdBus(reserva.getIdBus());
        setStatus(reserva.getStatus());
    }

    public ReservaInputDTO(){}
}
