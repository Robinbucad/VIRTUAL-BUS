package virtualbus.utils.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import virtualbus.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.bus.infraestructure.controller.dto.output.BusOutputDTO;

@FeignClient(value = "service-bus", url ="${FEIGN_CLIENT_URL:http://localhost:8084/api/v0}")
public interface BusClient {

    @PostMapping("/busesWeb")
    public ResponseEntity<BusOutputDTO> createBus(@RequestBody BusInputDTO busInputDTO);

}
