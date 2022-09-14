package virtualbus.backweb.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import virtualbus.backweb.reserva.infraestructure.controller.dto.input.ReservaInputDTO;

@Service
public class ReservaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservaProducer.class);

    private KafkaTemplate<String, ReservaInputDTO> kafkaTemplate;

    public ReservaProducer( KafkaTemplate<String, ReservaInputDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToReservas(ReservaInputDTO reservaInputDTO){
        LOGGER.info(String.format("Reserva event => %s", reservaInputDTO));

        //Create message
        Message<ReservaInputDTO>message = MessageBuilder
                .withPayload(reservaInputDTO)
                .setHeader(KafkaHeaders.TOPIC, "reservas_topic")
                .build();
        kafkaTemplate.send(message);
    }

    public void sendMessageToEmails(String email){
        LOGGER.info(String.format("Reserva event => %s", email));

        //Create message
        Message<String>message = MessageBuilder
                .withPayload(email)
                .setHeader(KafkaHeaders.TOPIC, "emails_topic")
                .build();
        kafkaTemplate.send(message);
    }


}
