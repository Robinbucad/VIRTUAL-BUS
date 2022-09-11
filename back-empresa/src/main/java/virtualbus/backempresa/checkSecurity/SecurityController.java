package virtualbus.backempresa.checkSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import virtualbus.backempresa.utils.model.Email;
import virtualbus.backempresa.utils.model.ReservasDisponibles;
import virtualbus.backweb.reserva.domain.ReservaEntity;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaDisponibleOutputDTO;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v0/checkSecurity")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    @GetMapping("/emails")
    public List<Email> getEmails(){
        return securityService.getEmails();
    }

    @GetMapping("/buses/{id}")
    public String getPlazas(@PathVariable String id){
        return securityService.getPlazas(id);
    }

    @GetMapping("/reservas/{id}")
    public List<ReservaOutputDTO> getReservasRealizadas(@PathVariable String id){
        return securityService.getReservasRealizadas(id);
    }

    @PostMapping("/emails/{to}")
    public String resendEmail(@PathVariable String to){
        return securityService.resendEmail(to);
    }

}
