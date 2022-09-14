package virtualbus.utils.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import virtualbus.reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import virtualbus.utils.model.Reserva;
import virtualbus.utils.model.ReservasDisponibles;

import java.util.List;

@FeignClient(value = "service-reservas", url ="${FEIGN_CLIENT_URL:http://localhost:8084/api/v0}")
public interface ReservasClient {

    @PostMapping("/reservasDisponiblesWeb")
    public ResponseEntity<ReservasDisponibles> createReservaDisponible(@RequestParam(value = "id_bus") String id_bus);

    @GetMapping("/reservasWeb/{id}")
    List<Reserva> getReservasRealizadas(@PathVariable String id);

    @PostMapping("/reservasWeb")
    public ResponseEntity<String> postReserva(
            @RequestBody ReservaInputDTO reserva,
            @RequestParam(value = "id_bus") String idBus
    );
}
