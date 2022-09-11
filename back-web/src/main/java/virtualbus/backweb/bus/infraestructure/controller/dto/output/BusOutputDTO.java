package virtualbus.backweb.bus.infraestructure.controller.dto.output;

import lombok.Data;
import virtualbus.backweb.bus.domain.BusEntity;

@Data
public class BusOutputDTO {
    private String idBus;
    private String ciudadSalida;
    private String ciudadDestino;
    private String fecha;
    private int hora;
    private int plazas;

    public BusOutputDTO(BusEntity bus){
        setIdBus(bus.getIdBus());
        setCiudadDestino(bus.getCiudadDestino());
        setFecha(bus.getFecha());
        setHora(bus.getHora());
        setPlazas(bus.getPlazas());
    }

    public BusOutputDTO(){}
}
