package virtualbus.backweb.reserva.infraestructure.controller;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import virtualbus.backweb.reserva.application.ReservaService;
import virtualbus.backweb.reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

@RestController
@RequestMapping("/api/v0")
public class PostReservaController {

    @Autowired
    ReservaService reservaService;

    @PostMapping("/reservas")
    public ResponseEntity<String> postReserva(
            @RequestBody ReservaInputDTO reserva,
            @RequestParam(value = "id_bus") String idBus,
            @RequestParam(value = "type", required = false, defaultValue = "reservas") String type
    ){
        String reservaOutputDTO = reservaService.postReserva(reserva,idBus);
        return ResponseEntity.ok(reservaOutputDTO);
    }

}
