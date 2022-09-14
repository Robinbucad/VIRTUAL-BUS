package virtualbus.backempresa.reservaDIsponible.domain;

import lombok.Data;
import virtualbus.backempresa.bus.domain.BusEntity;


import javax.persistence.Entity;
import javax.persistence.Id;
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
