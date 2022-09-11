package virtualbus.backweb.reserva.infraestructure.controller.dto.output;

import lombok.Data;
import virtualbus.backweb.bus.domain.BusEntity;
import virtualbus.backweb.reserva.domain.ReservaEntity;
import virtualbus.backweb.reserva.domain.ReservaStatus;

import javax.persistence.ManyToOne;

@Data
public class ReservaOutputDTO {


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


    public ReservaOutputDTO(ReservaEntity reserva, BusEntity bus){
        setReservaId(reserva.getReservaId());
        setCiudadDestino(bus.getCiudadDestino());
        setNombre(reserva.getNombre());
        setApellidos(reserva.getApellidos());
        setTelefono(reserva.getTelefono());
        setCorreoElectronico(reserva.getCorreoElectronico());
        setFecha(bus.getFecha());
        setHora(bus.getHora());
        setIdBus(bus.getIdBus());
        setReservaStatus(reserva.getStatus());
    }

    public ReservaOutputDTO(ReservaEntity reserva){
        setReservaId(reserva.getReservaId());
        setCiudadDestino(reserva.getCiudadDestino());
        setNombre(reserva.getNombre());
        setApellidos(reserva.getApellidos());
        setTelefono(reserva.getTelefono());
        setCorreoElectronico(reserva.getCorreoElectronico());
        setFecha(reserva.getFecha());
        setHora(reserva.getHora());
        setIdBus(reserva.getIdBus());
        setReservaStatus(reserva.getStatus());
    }

    public ReservaOutputDTO(){}
}
