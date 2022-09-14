package virtualbus.checkSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import virtualbus.email.infraestructure.controller.dto.output.EmailOutputDTO;
import virtualbus.reserva.application.ReservasService;
import virtualbus.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import virtualbus.utils.model.Email;
import virtualbus.utils.model.Reserva;


import java.util.List;

@RestController
@RequestMapping("/api/v0/checkSecurity")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    @Autowired
    ReservasService reservasService;


    @GetMapping("/emails")
    public List<EmailOutputDTO> getEmails(){
        return securityService.getEmails();
    }

    @GetMapping("/buses/{id}")
    public String getPlazas(@PathVariable String id){
        return securityService.getPlazas(id);
    }

    @GetMapping("/reservasRealizadas")
    public List<ReservaOutputDTO> reservasRealizadasBusDiaHoraDestino(
        @RequestParam (value = "id_bus") String id_bus,
        @RequestParam (value = "dia") String dia,
        @RequestParam (value = "hora") int hora,
        @RequestParam (value = "destino") String destino
    ){
        return reservasService.reservasRealizadasBusHoraDiaHoraDestino(id_bus,dia,hora,destino);
    }

    @PostMapping("/emails/{to}")
    public String resendEmail(@PathVariable String to){
        return securityService.resendEmail(to);
    }

}
