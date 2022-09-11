package virtualbus.emailservice.email.domain;

import lombok.Data;
import virtualbus.backweb.reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import javax.persistence.*;

@Entity(name = "emails")
@Data
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    @Enumerated(EnumType.STRING)
    private ReservaStatus reservaStatus;

    public EmailEntity(ReservaOutputDTO reserva){
        setNombre(reserva.getNombre());
        setEmail(reserva.getCorreoElectronico());
        setReservaStatus(ReservaStatus.ACEPTADO);
    }

    public EmailEntity(){}

}
