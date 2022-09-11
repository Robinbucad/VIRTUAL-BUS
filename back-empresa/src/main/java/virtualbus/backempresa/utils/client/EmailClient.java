package virtualbus.backempresa.utils.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import virtualbus.backempresa.utils.model.Email;

import java.util.List;

@FeignClient(value = "service-email", url ="http://localhost:8081/api/v0")
public interface EmailClient {

    @GetMapping("/emails")
    public List<Email> getEmails();

}
