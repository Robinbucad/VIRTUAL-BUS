package virtualbus.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {



    @Bean
    public NewTopic reservasTopic(){
        return TopicBuilder.name("reservas_topic").build();
    }

    @Bean
    public NewTopic emailTopic(){
        return TopicBuilder.name("emails_topic").build();
    }

}
