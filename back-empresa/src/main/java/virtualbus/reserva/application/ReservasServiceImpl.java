package virtualbus.reserva.application;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualbus.bus.domain.BusEntity;
import virtualbus.bus.infraestructure.repository.BusRepository;
import virtualbus.reserva.domain.ReservaEntity;
import virtualbus.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import virtualbus.reserva.infraestructure.repository.ReservasRepository;
import virtualbus.utils.exception.notFound.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservasServiceImpl implements ReservasService{

    @Autowired
    ReservasRepository reservasRepository;

    @Autowired
    BusRepository busRepository;

    @Override
    public List<ReservaOutputDTO> reservasRealizadasBusHoraDiaHoraDestino(String id_bus,String dia, int hora, String destino) {
        BusEntity bus = busRepository.findBusByIdBus(id_bus).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );

        List<ReservaEntity> reservas = reservasRepository.findByIdBus(id_bus);


        if (bus.getFecha().equals(dia) && bus.getHora() == hora && bus.getCiudadDestino().equalsIgnoreCase(destino)){
            List<ReservaOutputDTO> reservaOutputDTOS = new ArrayList<>();

            reservas.forEach(reservaEntity -> {
                ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(reservaEntity);
                reservaOutputDTOS.add(reservaOutputDTO);
            });

            return reservaOutputDTOS;
        }else {
            throw  new NotFoundException("Este bus para las fechas dadas no existe");
        }
    }
}
