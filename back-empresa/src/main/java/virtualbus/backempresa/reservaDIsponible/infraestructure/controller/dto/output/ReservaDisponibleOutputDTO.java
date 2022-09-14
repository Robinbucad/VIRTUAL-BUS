package virtualbus.backempresa.reservaDIsponible.infraestructure.controller.dto.output;

import lombok.Data;
import virtualbus.backempresa.reservaDIsponible.domain.ReservaDisponibleEntity;

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
