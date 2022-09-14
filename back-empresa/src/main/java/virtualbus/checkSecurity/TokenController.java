package virtualbus.checkSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class TokenController {

    @Autowired
    SecurityService securityService;


    @GetMapping("/token/{token}")
    public ResponseEntity<String> checkToken(@PathVariable String token){
        return ResponseEntity.ok(securityService.checkToken(token));
    }
}
