package virtualbus.backempresa.utils.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import virtualbus.backempresa.utils.model.ReservasDisponibles;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;

import java.util.List;

@FeignClient(value = "service-reservas", url ="http://localhost:8080/api/v0")
public interface ReservasClient {

    @PostMapping("/reservasDisponibles")
    public ResponseEntity<ReservasDisponibles> createReservaDisponible(@RequestParam(value = "id_bus") String id_bus);

    @GetMapping("/reservas/{id}")
    List<ReservaOutputDTO> getReservasRealizadas(@PathVariable String id);
}
