package virtualbus.bus.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualbus.bus.domain.BusEntity;
import virtualbus.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.bus.infraestructure.controller.dto.output.BusOutputDTO;
import virtualbus.bus.infraestructure.repository.BusRepository;
import virtualbus.exception.notFound.NotFoundException;
import virtualbus.exception.unprocessable.UnprocessableException;

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
        BusEntity bus = busRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Bus que busca no existe")
        );
        return new BusOutputDTO(bus);
    }
}
