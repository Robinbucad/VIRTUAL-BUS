package virtualbus.emailservice.email.infraestructure.controller.dto.output;

import lombok.Data;
import virtualbus.emailservice.email.domain.EmailEntity;
import virtualbus.emailservice.email.domain.ReservaStatus;


@Data
public class EmailOutputDTO {

    private Long id;
    private String email;
    private ReservaStatus reservaStatus;

    public EmailOutputDTO(EmailEntity email){
        setId(email.getId());
        setEmail(email.getEmail());
        setReservaStatus(email.getReservaStatus());
    }

    public EmailOutputDTO(){}

}
