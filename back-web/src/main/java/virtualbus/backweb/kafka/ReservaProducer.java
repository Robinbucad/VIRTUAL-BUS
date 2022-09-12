package virtualbus.backweb.kafka;

import org.apache.kafka.clients.admin.NewTopic;
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

    private NewTopic topic;

    private KafkaTemplate<String, String> kafkaTemplate;

    public ReservaProducer(NewTopic topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String id_bus){
        LOGGER.info(String.format("Reserva event => %s", id_bus));

        //Create message
        Message<String>message = MessageBuilder
                .withPayload(id_bus)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }


}
