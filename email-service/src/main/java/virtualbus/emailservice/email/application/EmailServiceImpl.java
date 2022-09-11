package virtualbus.emailservice.email.application;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import virtualbus.emailservice.email.domain.EmailEntity;
import virtualbus.emailservice.email.infraestructure.controller.dto.output.EmailOutputDTO;
import virtualbus.emailservice.email.infraestructure.repository.EmailRepository;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender mailSender;

    @Autowired
    EmailRepository emailRepository;

    @Override
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setText(email,true);
            helper.setTo(to);
            helper.setSubject("Agencia viajes");
            helper.setFrom("robin.bucad@bosonit.com");
            mailSender.send(mimeMessage);
        }catch (Exception e){
            throw new IllegalStateException("Failed");
        }
    }

    @Override
    public List<EmailOutputDTO> getEmails() {
        List<EmailEntity> emails = emailRepository.findAll();
        List<EmailOutputDTO> emailOutputDTOS = new ArrayList<>();

        for (EmailEntity e: emails){
            EmailOutputDTO emailOutputDTO = new EmailOutputDTO(e);
            emailOutputDTOS.add(emailOutputDTO);
        }
        return emailOutputDTOS;
    }
}
