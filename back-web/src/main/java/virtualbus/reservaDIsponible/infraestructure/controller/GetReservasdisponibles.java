package virtualbus.reservaDIsponible.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.reservaDIsponible.application.ReservaDisponibleService;

@RestController
@RequestMapping("/api/v0/reservasDisponiblesWeb/plazas")
public class GetReservasdisponibles {

    @Autowired
    ReservaDisponibleService reservaDisponibleService;

    @GetMapping
    public ResponseEntity<String> getPlazasDisponiblesBus(
            @RequestParam (value = "id_bus") String id_bus,
            @RequestParam (value = "destino") String destino,
            @RequestParam (value = "dia") String dia,
            @RequestParam (value = "hora") int hora
    ){
        return ResponseEntity.ok(reservaDisponibleService.plazasDisponiblesBus(id_bus,destino, dia, hora));
    }

}
