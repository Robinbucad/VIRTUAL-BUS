package virtualbus.backempresa.reserva.infraestructure.controller.dto.input;

import lombok.Data;
import virtualbus.backempresa.bus.domain.BusEntity;
import virtualbus.backempresa.reserva.domain.ReservaEntity;
import virtualbus.backempresa.reserva.domain.ReservaStatus;

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


    public ReservaInputDTO (ReservaEntity reserva, BusEntity bus){
        setReservaId(reserva.getReservaId());
        setCiudadDestino(bus.getCiudadDestino());
        setNombre(reserva.getNombre());
        setApellidos(reserva.getApellidos());
        setTelefono(reserva.getTelefono());
        setCorreoElectronico(reserva.getCorreoElectronico());
        setFecha(bus.getFecha());
        setHora(bus.getHora());
        setIdBus(bus.getIdBus());
        setStatus(ReservaStatus.PENDIENTE);
    }

    public ReservaInputDTO(){}
}
