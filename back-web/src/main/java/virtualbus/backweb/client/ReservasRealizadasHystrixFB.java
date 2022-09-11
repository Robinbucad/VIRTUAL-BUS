package virtualbus.backweb.client;


import antlr.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ReservasRealizadasHystrixFB implements ReservasRealizadasClient{
    @Override
    public ResponseEntity<String> checkToken(String token) {
        String tokenHystrix = " Otro token ";
        return ResponseEntity.ok(tokenHystrix);
    }
}
