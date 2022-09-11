package virtualbus.backweb.reservaDIsponible.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import virtualbus.backweb.reservaDIsponible.application.ReservaDisponibleService;
import virtualbus.backweb.reservaDIsponible.infraestructure.controller.dto.output.ReservaDisponibleOutputDTO;

@RestController
@RequestMapping("/api/v0")
public class PostReservasDisponiblesController {

    @Autowired
    ReservaDisponibleService reservaDisponibleService;

    @PostMapping("/reservasDisponibles")
    public ResponseEntity<ReservaDisponibleOutputDTO> createReservaDisponible(
            @RequestParam (value = "id_bus") String id_bus
    ){
        ReservaDisponibleOutputDTO reservaDisponibleOutputDTO = reservaDisponibleService.createReservaDisponible(id_bus);
        return ResponseEntity.ok(reservaDisponibleOutputDTO);
    }
}
