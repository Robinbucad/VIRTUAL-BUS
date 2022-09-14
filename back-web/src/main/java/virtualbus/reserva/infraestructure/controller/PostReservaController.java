package virtualbus.reserva.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import virtualbus.reserva.application.ReservaService;
import virtualbus.reserva.infraestructure.controller.dto.input.ReservaInputDTO;

@RestController
@RequestMapping("/api/v0/reservasWeb")
public class PostReservaController {

    @Autowired
    ReservaService reservaService;

    @PostMapping
    public ResponseEntity<String> postReserva(
            @RequestBody ReservaInputDTO reserva,
            @RequestParam(value = "id_bus") String idBus
    ){
        String reservaOutputDTO = reservaService.postReserva(reserva,idBus);
        return ResponseEntity.ok(reservaOutputDTO);
    }

}
