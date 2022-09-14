package virtualbus.backempresa.reserva.domain;

import lombok.Data;
import virtualbus.backempresa.bus.domain.BusEntity;
import virtualbus.backempresa.reserva.infraestructure.controller.dto.input.ReservaInputDTO;


import javax.persistence.*;

@Data
@Entity(name = "Reservas")
public class ReservaEntity {
    @Id
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

    @ManyToOne
    private BusEntity bus;

    public ReservaEntity(ReservaInputDTO reserva, BusEntity bus){
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
        setBus(bus);
    }

    public ReservaEntity(){}
}
