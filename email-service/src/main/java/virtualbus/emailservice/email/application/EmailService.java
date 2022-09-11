package virtualbus.emailservice.email.application;

import virtualbus.emailservice.email.infraestructure.controller.dto.output.EmailOutputDTO;

import java.util.List;

public interface EmailService {
     void send(String to,String email);

     List<EmailOutputDTO> getEmails();
}
