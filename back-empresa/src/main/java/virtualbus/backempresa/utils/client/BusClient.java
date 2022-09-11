package virtualbus.backempresa.utils.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import virtualbus.backempresa.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.backempresa.bus.infraestructure.controller.dto.output.BusOutputDTO;

@FeignClient(value = "service-bus", url ="http://localhost:8080/api/v0")
public interface BusClient {

    @PostMapping("/buses")
    public ResponseEntity<BusOutputDTO> createBus(@RequestBody BusInputDTO busInputDTO);

}
