package virtualbus.checkSecurity;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualbus.bus.application.BusService;
import virtualbus.kafka.EmpresaProducer;
import virtualbus.utils.client.EmailClient;
import virtualbus.utils.client.ReservasClient;
import virtualbus.utils.exception.notFound.NotFoundException;
import virtualbus.utils.model.Email;
import virtualbus.utils.model.Reserva;

import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService{

    @Autowired
    EmailClient emailClient;

    @Autowired
    ReservasClient reservasClient;

    @Autowired
    BusService busService;

    @Autowired
    EmpresaProducer empresaProducer;



    @Override
    public List<Reserva> getReservasRealizadas(String id) {
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
    public String resendEmail(String to) {
        empresaProducer.sendMessage(to);
        return "Email reenviado correctamente";
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
