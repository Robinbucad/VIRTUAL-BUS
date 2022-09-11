package virtualbus.backweb.reserva.infraestructure.controller.dto.output;

import lombok.Data;
import virtualbus.backweb.bus.domain.BusEntity;

@Data
public class ReservaDisponibleOutputDTO {
    private String ciudadDestino;
    private String fechaSalida;
    private int horaSalida;
    private int numeroPlazas;

    public ReservaDisponibleOutputDTO(BusEntity bus){
        setCiudadDestino(bus.getCiudadDestino());
        setFechaSalida(bus.getFecha());
        setHoraSalida(bus.getHora());
        setNumeroPlazas(bus.getPlazas());
    }
}
