package virtualbus.bus.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.bus.application.BusService;
import virtualbus.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.bus.infraestructure.controller.dto.output.BusOutputDTO;

@RestController
@RequestMapping("api/v0/busesWeb")
public class PostBusController {

    @Autowired
    BusService busService;

    @PostMapping
    public ResponseEntity<BusOutputDTO> postBus(@RequestBody BusInputDTO bus){
        BusOutputDTO busOutputDTO = busService.createBus(bus);
        return ResponseEntity.ok(busOutputDTO);
    }

}
