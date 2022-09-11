package virtualbus.backweb.reserva.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import virtualbus.backweb.reserva.application.ReservaService;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v0/reservas")
public class GetReservaController {

    @Autowired
    ReservaService reservaService;

    @GetMapping("/token/{token}")
    List<ReservaOutputDTO> getAllReservas(@PathVariable String token){
        return reservaService.getAllReservas(token);
    }

    @GetMapping("/{id}")
    List<ReservaOutputDTO> getReservasRealizadas(@PathVariable String id){
        return  reservaService.getReservasList(id);
    }






}
