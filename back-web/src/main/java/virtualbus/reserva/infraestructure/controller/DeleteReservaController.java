package virtualbus.reserva.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.reserva.application.ReservaService;

@RestController
@RequestMapping("/api/v0/reservasWeb")
public class DeleteReservaController {

    @Autowired
    ReservaService reservaService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReserva(@PathVariable String id){
        return ResponseEntity.ok(reservaService.cancelReserva(id));
    }

}
