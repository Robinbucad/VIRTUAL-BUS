package virtualbus.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import virtualbus.bus.application.BusService;
import virtualbus.bus.domain.BusEntity;
import virtualbus.bus.infraestructure.repository.BusRepository;
import virtualbus.reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import virtualbus.utils.exception.notFound.NotFoundException;

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
    public void consume(ReservaInputDTO reservaInputDTO){
        System.out.println(reservaInputDTO);
        BusEntity bus = busRepository.findBusByIdBus(reservaInputDTO.getIdBus()).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );
        bus.setPlazas(bus.getPlazas()-1);
        busService.checkPlazas(bus.getIdBus());
        busRepository.save(bus);
        LOGGER.info(String.format("Order event received in empresa service => %s", reservaInputDTO));
    }
}
