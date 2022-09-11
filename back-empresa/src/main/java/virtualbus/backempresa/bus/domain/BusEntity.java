package virtualbus.backempresa.bus.domain;

import lombok.Data;
import virtualbus.backempresa.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.backweb.bus.domain.BusStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity(name = "Buses")
public class BusEntity {

    @Id
    private String idBus;
    private String ciudadDestino;
    private String fecha;
    private int hora;
    private int plazas;
    @Enumerated(EnumType.STRING)
    private BusStatus busStatus;

    public BusEntity(BusInputDTO bus){
        setIdBus(bus.getIdBus());
        setCiudadDestino(bus.getCiudadDestino());
        setFecha(bus.getFecha());
        setHora(bus.getHora());
        setPlazas(40);
        setBusStatus(BusStatus.ACEPTADO);
    }

    public BusEntity(){}

}
