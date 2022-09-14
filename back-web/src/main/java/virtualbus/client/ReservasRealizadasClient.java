package virtualbus.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-reservas", url ="${FEIGN_CLIENT_URL:http://localhost:8085/api/v0}", fallback = ReservasRealizadasHystrixFB.class)
public interface ReservasRealizadasClient {

    @GetMapping("/token/{token}")
    public ResponseEntity<String> checkToken(@PathVariable String token);
}
