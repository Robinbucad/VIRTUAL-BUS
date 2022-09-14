package virtualbus.backempresa.bus.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualbus.backempresa.bus.domain.BusEntity;
import virtualbus.backempresa.bus.infraestructure.controller.dto.input.BusInputDTO;
import virtualbus.backempresa.bus.infraestructure.controller.dto.output.BusOutputDTO;
import virtualbus.backempresa.bus.infraestructure.repository.BusRepository;
import virtualbus.backempresa.utils.exception.notFound.NotFoundException;
import virtualbus.backempresa.utils.exception.unprocessable.UnprocessableException;
import virtualbus.backempresa.utils.client.BusClient;
import virtualbus.backempresa.utils.client.ReservasClient;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;

    @Autowired
    BusClient busClient;

    @Autowired
    ReservasClient reservasClient;
    @Override
    public BusOutputDTO createBus(BusInputDTO bus) {
        BusEntity checkBus = busRepository.findBusByHora(bus.getHora()).orElse(null);
        if (checkBus != null && checkBus.getCiudadDestino().equalsIgnoreCase(bus.getCiudadDestino())) {
            throw new UnprocessableException("No se puede crear otro bus que salga a la misma hora y tenga el mismo destino");
        };

        bus.setIdBus(UUID.randomUUID().toString());
        BusEntity newBus = new BusEntity(bus);

        busRepository.save(newBus);
        busClient.createBus(bus).getBody();
        reservasClient.createReservaDisponible(bus.getIdBus());
        return new BusOutputDTO(newBus);
    }

    @Override
    public BusOutputDTO getBusById(String id) {
        BusEntity bus = busRepository.findBusByIdBus(id).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );
        return new BusOutputDTO(bus);
    }

    @Override
    public String checkPlazas(String id) {
        BusEntity bus = busRepository.findBusByIdBus(id).orElseThrow(
                ()-> new NotFoundException("Bus no existe"));
        if (bus.getPlazas()==0){
            throw new UnprocessableException("Bus lleno");
        }

        return "El bus aun tiene plazas: " + bus.getPlazas();

    }

    @Override
    public List<BusOutputDTO> getBuses() {
        List<BusEntity> busEntities = busRepository.findAll();
        List<BusOutputDTO> busOutputDTOS = new ArrayList<>();
        for (BusEntity b:busEntities){
            BusOutputDTO busDTO = new BusOutputDTO(b);
            busOutputDTOS.add(busDTO);
        }
        return busOutputDTOS;
    }
}
