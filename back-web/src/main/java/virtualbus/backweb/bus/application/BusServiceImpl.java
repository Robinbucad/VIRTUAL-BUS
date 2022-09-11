package virtualbus.backweb.bus.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualbus.backweb.bus.domain.BusEntity;
import virtualbus.backweb.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.backweb.bus.infraestructure.controller.dto.output.BusOutputDTO;
import virtualbus.backweb.bus.infraestructure.repository.BusRepository;
import virtualbus.backweb.exception.notFound.NotFoundException;
import virtualbus.backweb.exception.unprocessable.UnprocessableException;

import java.util.UUID;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    BusRepository busRepository;

    @Override
    public BusOutputDTO createBus(BusInputDTO bus) {
        BusEntity checkBus = busRepository.findBusByHora(bus.getHora()).orElse(null);
        if (checkBus != null && checkBus.getCiudadDestino().equalsIgnoreCase(bus.getCiudadDestino())) {
            throw new UnprocessableException("No se puede crear otro bus que salga a la misma hora y tenga el mismo destino");
        };

        BusEntity newBus = new BusEntity(bus);

        busRepository.save(newBus);
        return new BusOutputDTO(newBus);
    }

    @Override
    public BusOutputDTO getBusById(String id) {
        BusEntity bus = busRepository.findBusByIdBus(id).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );
        return new BusOutputDTO(bus);
    }
}
