package virtualbus.backweb.bus.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.backweb.bus.application.BusService;
import virtualbus.backweb.bus.infraestructure.controller.dto.output.BusOutputDTO;

@RestController
@RequestMapping("api/v0/buses")
public class GetBusController {

    @Autowired
    BusService busService;

    @GetMapping("/{id}")
    public ResponseEntity<BusOutputDTO> getBusById(@PathVariable String id){
        BusOutputDTO busOutputDTO = busService.getBusById(id);
        return ResponseEntity.ok(busOutputDTO);
    }

}
