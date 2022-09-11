package virtualbus.backempresa.checkSecurity;

import org.springframework.web.bind.annotation.PathVariable;
import virtualbus.backempresa.utils.model.Email;
import virtualbus.backempresa.utils.model.ReservasDisponibles;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.List;

public interface SecurityService {
    List<ReservaOutputDTO> getReservasRealizadas(String id);
    String getPlazas(String id);

    List<Email> getEmails();

    Email resend(Long id);

}
