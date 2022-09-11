package virtualbus.backweb.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
@Service
public class ReservaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservaProducer.class);

    private NewTopic topic;

    private KafkaTemplate<String, ReservaOutputDTO> kafkaTemplate;

    public ReservaProducer(NewTopic topic, KafkaTemplate<String, ReservaOutputDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ReservaOutputDTO reserva){
        LOGGER.info(String.format("Reserva event => %s", reserva.toString()));

        //Create message
        Message<ReservaOutputDTO>message = MessageBuilder
                .withPayload(reserva)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }


}
