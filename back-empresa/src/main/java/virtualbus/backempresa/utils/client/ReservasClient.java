package virtualbus.backempresa.utils.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import virtualbus.backempresa.utils.model.Reserva;
import virtualbus.backempresa.utils.model.ReservasDisponibles;

import java.util.List;

@FeignClient(value = "service-reservas", url ="${FEIGN_CLIENT_URL:http://localhost:8084/api/v0}")
public interface ReservasClient {

    @PostMapping("/reservasDisponiblesWeb")
    public ResponseEntity<ReservasDisponibles> createReservaDisponible(@RequestParam(value = "id_bus") String id_bus);

    @GetMapping("/reservasWeb/{id}")
    List<Reserva> getReservasRealizadas(@PathVariable String id);
}
