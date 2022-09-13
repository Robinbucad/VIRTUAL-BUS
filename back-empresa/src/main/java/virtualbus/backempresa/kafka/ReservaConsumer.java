package virtualbus.backempresa.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import virtualbus.backempresa.bus.application.BusService;
import virtualbus.backempresa.bus.domain.BusEntity;
import virtualbus.backempresa.bus.infraestructure.repository.BusRepository;
import virtualbus.backempresa.reservas.domain.ReservaOrder;
import virtualbus.backempresa.utils.model.Reserva;

import java.awt.*;
import java.io.PrintStream;

@Service
public class ReservaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservaConsumer.class);

    @Autowired
    BusRepository busRepository;

    @Autowired
    BusService busService;

    @KafkaListener(
            topics = "reservas_topic",
            groupId = "emp"
    )
    public void consume(ReservaOrder reservaOrder){
        System.out.println(reservaOrder);
        /*
         BusEntity bus = busRepository.findBusByIdBus(id_bus);
        bus.setPlazas(bus.getPlazas()-1);
        busService.checkPlazas(bus.getIdBus());
        busRepository.save(bus);
        * */
        LOGGER.info(String.format("Order event received in empresa service => %s", reservaOrder));
    }
}
