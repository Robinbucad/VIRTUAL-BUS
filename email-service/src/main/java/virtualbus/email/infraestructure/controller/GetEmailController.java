package virtualbus.email.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.email.application.EmailService;
import virtualbus.email.infraestructure.controller.dto.output.EmailOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class GetEmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/emails")
    public List<EmailOutputDTO> getEmails(){
        List<EmailOutputDTO> emailOutputDTOS = emailService.getEmails();
        return emailOutputDTOS;
    }

}
