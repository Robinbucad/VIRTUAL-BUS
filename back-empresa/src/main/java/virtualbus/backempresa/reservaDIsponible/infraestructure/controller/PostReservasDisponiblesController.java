package virtualbus.backempresa.reservaDIsponible.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.backempresa.reservaDIsponible.application.ReservaDisponibleService;
import virtualbus.backempresa.reservaDIsponible.infraestructure.controller.dto.output.ReservaDisponibleOutputDTO;


@RestController
@RequestMapping("/api/v0/reservasDisponiblesEmpresa")
public class PostReservasDisponiblesController {

    @Autowired
    ReservaDisponibleService reservaDisponibleService;

    @PostMapping
    public ResponseEntity<ReservaDisponibleOutputDTO> createReservaDisponible(
            @RequestParam (value = "id_bus") String id_bus
    ){
        ReservaDisponibleOutputDTO reservaDisponibleOutputDTO = reservaDisponibleService.createReservaDisponible(id_bus);
        return ResponseEntity.ok(reservaDisponibleOutputDTO);
    }
}
