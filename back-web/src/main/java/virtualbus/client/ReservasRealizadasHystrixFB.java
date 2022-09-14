package virtualbus.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ReservasRealizadasHystrixFB implements ReservasRealizadasClient{

    Logger LOGGER = LoggerFactory.getLogger(ReservasRealizadasHystrixFB.class);
    @Override
    public ResponseEntity<String> checkToken(String token) {
        LOGGER.info(String.format("Error check token server empresa not up "));
        return ResponseEntity.ok("Error check token server empresa not up ");
    }
}
