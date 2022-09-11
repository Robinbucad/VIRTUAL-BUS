package virtualbus.backweb.reservaDIsponible.domain;

import lombok.Data;
import virtualbus.backweb.bus.domain.BusEntity;
import virtualbus.backweb.bus.domain.BusStatus;
import virtualbus.backweb.reserva.domain.ReservaEntity;
import virtualbus.backweb.reservaDIsponible.infraestructure.controller.dto.input.ReservaDisponibleInputDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity(name = "reservaDisponible")
@Data
public class ReservaDisponibleEntity {

    @Id
    private String idReserva;
    private String idBus;
    private String ciudadDestino;
    private String fechaSalida;
    private int horaSalida;
    private int numeroPlazas;


    public ReservaDisponibleEntity(BusEntity bus){
        setIdReserva(UUID.randomUUID().toString());
        setIdBus(bus.getIdBus());
        setCiudadDestino(bus.getCiudadDestino());
        setFechaSalida(bus.getFecha());
        setHoraSalida(bus.getHora());
        setNumeroPlazas(bus.getPlazas());
    }

    public ReservaDisponibleEntity(){}
}
