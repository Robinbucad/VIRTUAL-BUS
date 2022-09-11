package virtualbus.backempresa.utils.model;

import lombok.Data;

@Data
public class ReservasDisponibles {
    private String ciudadDestino;
    private String fechaSalida;
    private int horaSalida;
    private int numeroPlazas;
}
