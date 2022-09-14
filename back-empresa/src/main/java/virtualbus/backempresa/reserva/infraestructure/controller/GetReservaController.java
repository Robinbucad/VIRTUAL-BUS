package virtualbus.backempresa.reserva.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.backempresa.reserva.application.ReservaService;
import virtualbus.backempresa.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;


import java.util.List;

@RestController
@RequestMapping("/api/v0/reservasEmpresa")
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
