package virtualbus.bus.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.bus.application.BusService;
import virtualbus.bus.infraestructure.controller.dto.output.BusOutputDTO;

import java.util.List;


@RestController
@RequestMapping("api/v0/busesEmpresa")
public class GetBusController {

    @Autowired
    BusService busService;

    @GetMapping
    public List<BusOutputDTO> getBuses(){
        return busService.getBuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusOutputDTO> getBusById(@PathVariable String id){
        BusOutputDTO busOutputDTO = busService.getBusById(id);
        return ResponseEntity.ok(busOutputDTO);
    }

}
