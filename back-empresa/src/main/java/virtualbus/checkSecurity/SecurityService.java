package virtualbus.checkSecurity;

import virtualbus.utils.model.Email;
import virtualbus.utils.model.Reserva;

import java.util.List;

public interface SecurityService {
    List<Reserva> getReservasRealizadas(String id);
    String getPlazas(String id);

    List<Email> getEmails();

    String resendEmail(String to);

    String checkToken(String token);

}
