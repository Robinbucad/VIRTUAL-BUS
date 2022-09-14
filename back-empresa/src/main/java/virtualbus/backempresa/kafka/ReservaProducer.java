package virtualbus.backempresa.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ReservaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public ReservaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToReservas(String id_bus){
        LOGGER.info(String.format("Reserva event => %s", id_bus));

        //Create message
        Message<String>message = MessageBuilder
                .withPayload(id_bus)
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
