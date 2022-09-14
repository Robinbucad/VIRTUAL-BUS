package virtualbus.email.application;

import virtualbus.email.infraestructure.controller.dto.output.EmailOutputDTO;

import java.util.List;

public interface EmailService {
     void send(String to,String email);

     List<EmailOutputDTO> getEmails();

     void resend(String to);

}
