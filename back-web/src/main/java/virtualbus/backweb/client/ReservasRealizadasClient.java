package virtualbus.backweb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-reservas", url ="http://localhost:8085/api/v0")
public interface ReservasRealizadasClient {

    @GetMapping("/token/{token}")
    public ResponseEntity<String> checkToken(@PathVariable String token);
}
