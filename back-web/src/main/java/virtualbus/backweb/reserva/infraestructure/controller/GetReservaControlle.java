package virtualbus.backweb.reserva.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import virtualbus.backweb.reserva.application.ReservaService;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaDisponibleOutputDTO;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v0/reservas")
public class GetReservaControlle {

    @Autowired
    ReservaService reservaService;

    @GetMapping("/{id}")
    List<ReservaOutputDTO> getReservasRealizadas(@PathVariable String id){
        return  reservaService.getReservasList(id);
    }



}
