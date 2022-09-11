package virtualbus.backempresa.checkSecurity;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualbus.backempresa.bus.application.BusService;
import virtualbus.backempresa.utils.client.EmailClient;
import virtualbus.backempresa.utils.client.ReservasClient;
import virtualbus.backempresa.utils.model.Email;
import virtualbus.backempresa.utils.model.ReservasDisponibles;
import virtualbus.backweb.exception.notFound.NotFoundException;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService{

    @Autowired
    EmailClient emailClient;

    @Autowired
    ReservasClient reservasClient;

    @Autowired
    BusService busService;


    @Override
    public List<ReservaOutputDTO> getReservasRealizadas(String id) {
        return reservasClient.getReservasRealizadas(id);
    }

    @Override
    public String getPlazas(String id) {
     return busService.checkPlazas(id);
    }

    @Override
    public List<Email> getEmails() {
        return emailClient.getEmails();
    }

    @Override
    public Email resend(Long id) {
        return null;
    }

    @Override
    public String checkToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256("secret".getBytes()))
                    .build()
                    .verify(token)
                    .getToken();
            return "Token válido";
        }catch (Exception e){
            throw new NotFoundException("Token no existe o expirado" + e.getMessage());
        }

    }
}
