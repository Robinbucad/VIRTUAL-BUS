package virtualbus.backweb.reservaDIsponible.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualbus.backweb.bus.domain.BusEntity;
import virtualbus.backweb.bus.infraestructure.repository.BusRepository;
import virtualbus.backweb.exception.notFound.NotFoundException;
import virtualbus.backweb.reserva.infraestructure.repository.ReservasRepository;
import virtualbus.backweb.reservaDIsponible.domain.ReservaDisponibleEntity;
import virtualbus.backweb.reservaDIsponible.infraestructure.controller.dto.output.ReservaDisponibleOutputDTO;
import virtualbus.backweb.reservaDIsponible.infraestructure.repository.ReservasDisponiblesRepository;

@Service
public class ReservaDisponibleServiceImpl implements ReservaDisponibleService{

    @Autowired
    ReservasRepository reservasRepository;

    @Autowired
    ReservasDisponiblesRepository reservaDisponibleRepository;

    @Autowired
    BusRepository busRepository;


    @Override
    public String plazasDisponiblesBus(String id_bus,String destino, String dia, int hora) {
        BusEntity bus = busRepository.findById(id_bus).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );

        if (bus.getCiudadDestino().equals(destino) && bus.getFecha().equals(dia) && bus.getHora() == hora){
            return "El bus dirección " + bus.getCiudadDestino() + " para el dia " + bus.getFecha() + " y hora "
                    + bus.getHora() + " tiene disponible " +  bus.getPlazas() +" plazas";

        }else {
            throw new NotFoundException("Bus en concreto no existe");
        }
    }

    @Override
    public ReservaDisponibleOutputDTO createReservaDisponible(String id_bus) {

        BusEntity bus = busRepository.findById(id_bus).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );

            ReservaDisponibleEntity reservaDisponible = new ReservaDisponibleEntity(bus);
            reservaDisponibleRepository.save(reservaDisponible);
            return new ReservaDisponibleOutputDTO(reservaDisponible);

    }

}
