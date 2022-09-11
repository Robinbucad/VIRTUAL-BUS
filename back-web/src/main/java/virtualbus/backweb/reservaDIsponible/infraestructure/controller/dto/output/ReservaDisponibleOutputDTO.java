package virtualbus.backweb.reservaDIsponible.infraestructure.controller.dto.output;

import lombok.Data;
import virtualbus.backweb.reservaDIsponible.domain.ReservaDisponibleEntity;

@Data
public class ReservaDisponibleOutputDTO {
    private String ciudadDestino;
    private String fechaSalida;
    private int horaSalida;
    private int numeroPlazas;

    public ReservaDisponibleOutputDTO(ReservaDisponibleEntity reservaDisponible){
        setCiudadDestino(reservaDisponible.getCiudadDestino());
        setFechaSalida(reservaDisponible.getFechaSalida());
        setHoraSalida(reservaDisponible.getHoraSalida());
        setNumeroPlazas(reservaDisponible.getNumeroPlazas());
    }
    public ReservaDisponibleOutputDTO(){}
}
