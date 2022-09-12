package virtualbus.backempresa.checkSecurity;

import org.springframework.web.bind.annotation.PathVariable;
import virtualbus.backempresa.utils.model.Email;
import virtualbus.backempresa.utils.model.Reserva;
import virtualbus.backempresa.utils.model.ReservasDisponibles;

import java.util.List;

public interface SecurityService {
    List<Reserva> getReservasRealizadas(String id);
    String getPlazas(String id);

    List<Email> getEmails();

    String resendEmail(String to);

    String checkToken(String token);

}
