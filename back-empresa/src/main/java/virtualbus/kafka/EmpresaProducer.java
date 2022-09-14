package virtualbus.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import virtualbus.utils.model.Email;

@Service
public class EmpresaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpresaProducer.class);

    private KafkaTemplate<String, Email> kafkaTemplate;

    public EmpresaProducer(KafkaTemplate<String, Email> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String to){
        LOGGER.info(String.format("Email event => %s",to));

        //Create message
        Message<String> message = MessageBuilder
                .withPayload(to)
                .setHeader(KafkaHeaders.TOPIC, "emails")
                .build();
        kafkaTemplate.send(message);
    }
}
