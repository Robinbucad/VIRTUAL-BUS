package virtualbus.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import virtualbus.bus.application.BusService;
import virtualbus.bus.domain.BusEntity;
import virtualbus.bus.infraestructure.repository.BusRepository;
import virtualbus.email.application.EmailService;
import virtualbus.email.domain.EmailEntity;
import virtualbus.email.infraestructure.repository.EmailRepository;
import virtualbus.reserva.domain.ReservaEntity;
import virtualbus.reserva.domain.ReservaStatus;
import virtualbus.reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import virtualbus.reserva.infraestructure.repository.ReservasRepository;
import virtualbus.utils.exception.notFound.NotFoundException;
import virtualbus.utils.exception.unprocessable.UnprocessableException;

@Service
public class ReservaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservaConsumer.class);

    @Autowired
    BusRepository busRepository;

    @Autowired
    BusService busService;

    @Autowired
    EmailService emailService;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    ReservasRepository reservasRepository;

    @KafkaListener(
            topics = "reservas_topic",
            groupId = "emp"
    )
    public void consume(ReservaInputDTO reservaInputDTO){
        System.out.println(reservaInputDTO);


        BusEntity bus = busRepository.findBusByIdBus(reservaInputDTO.getIdBus()).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );



        System.out.println(reservaInputDTO.getStatus());
        if (reservaInputDTO.getStatus().equals(ReservaStatus.PENDIENTE)){
            bus.setPlazas(bus.getPlazas()-1);
            busService.checkPlazas(bus.getIdBus());
            busRepository.save(bus);

            reservasRepository.save(new ReservaEntity(reservaInputDTO,bus));

            emailService.send(reservaInputDTO.getCorreoElectronico(), buildEmail("Gracias por realizar la reserva"));
            EmailEntity email = new EmailEntity(reservaInputDTO.getCorreoElectronico());
            emailRepository.save(email);
        }
        if (reservaInputDTO.getStatus().equals(ReservaStatus.CANCELADO)){
            EmailEntity emailCheck = emailRepository.findEmailByEmail(reservaInputDTO.getCorreoElectronico()).orElseThrow(
                    ()-> new NotFoundException("Email no existe")
            );
            bus.setPlazas(bus.getPlazas()+1);
            busService.checkPlazas(bus.getIdBus());
            busRepository.save(bus);

            ReservaEntity reserva = reservasRepository.findById(reservaInputDTO.getReservaId()).orElseThrow(
                    () -> new NotFoundException("Reserva no existe")
            );
            reservasRepository.delete(reserva);
            emailService.send(reservaInputDTO.getCorreoElectronico(), buildEmail("Reserva cancelada correctamente"));
            emailCheck.setReservaStatus(virtualbus.email.domain.ReservaStatus.CANCELADO);
            emailRepository.save(emailCheck);
        }

        LOGGER.info(String.format("Order event received in empresa service => %s", reservaInputDTO));

    }

    private String buildEmail(String reserva) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Robin viajes</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hola pasajero ,</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">"+ reserva + "</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> </p></blockquote>\n Nos vemos pronto" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }
}
