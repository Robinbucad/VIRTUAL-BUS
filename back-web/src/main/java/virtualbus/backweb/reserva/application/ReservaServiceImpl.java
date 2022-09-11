package virtualbus.backweb.reserva.application;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualbus.backweb.bus.domain.BusEntity;
import virtualbus.backweb.bus.infraestructure.repository.BusRepository;
import virtualbus.backweb.client.ReservasRealizadasClient;
import virtualbus.backweb.exception.notFound.NotFoundException;
import virtualbus.backweb.exception.unprocessable.UnprocessableException;
import virtualbus.backweb.kafka.ReservaProducer;
import virtualbus.backweb.reserva.domain.ReservaEntity;
import virtualbus.backweb.reserva.domain.ReservaStatus;
import virtualbus.backweb.reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaDisponibleOutputDTO;
import virtualbus.backweb.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import virtualbus.backweb.reserva.infraestructure.repository.ReservasRepository;
import virtualbus.backweb.reservaDIsponible.domain.ReservaDisponibleEntity;
import virtualbus.backweb.reservaDIsponible.infraestructure.repository.ReservasDisponiblesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReservaServiceImpl implements ReservaService{

    private ReservaProducer reservaProducer;

    @Autowired
    ReservasRepository reservasRepository;

    @Autowired
    BusRepository busRepository;

    @Autowired
    ReservasDisponiblesRepository reservasDisponiblesRepository;

    @Autowired
    ReservasRealizadasClient reservasRealizadasClient;

    public ReservaServiceImpl(ReservaProducer reservaProducer) {
        this.reservaProducer = reservaProducer;
    }

    @Override
    public List<ReservaOutputDTO> getAllReservas(String token) {

        String checkToken = reservasRealizadasClient.checkToken(token).getBody();
        if (checkToken.equals("Token válido")){
            List<ReservaEntity> reservaEntities = reservasRepository.findAll();
            List<ReservaOutputDTO> reservasDTO = new ArrayList<>();

            for (ReservaEntity r:reservaEntities){
                ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(r);
                reservasDTO.add(reservaOutputDTO);
            }
            return reservasDTO;
        }
        else {
            throw new NotFoundException("Token inválido");
        }


    }

    @Override
    public String postReserva(ReservaInputDTO reservaInputDTO, String idBus) {
        reservaInputDTO.setReservaId(UUID.randomUUID().toString());
        BusEntity bus = busRepository.findBusByIdBus(idBus).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );

        ReservaDisponibleEntity reservaDisponible = reservasDisponiblesRepository.findReservaDisponibleByIdBus(bus.getIdBus()).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );


        if (bus.getPlazas()==0){
            throw new UnprocessableException("Bus lleno");
        }

        reservaDisponible.setNumeroPlazas(reservaDisponible.getNumeroPlazas()-1);
        bus.setPlazas(bus.getPlazas()-1);

        ReservaEntity reserva = new ReservaEntity(reservaInputDTO,bus);
        reservaProducer.sendMessage(new ReservaOutputDTO(reserva,bus));
        reserva.setStatus(ReservaStatus.ACEPTADO);
        reservasRepository.save(reserva);
        reservasDisponiblesRepository.save(reservaDisponible);
        return "Gracias por la reserva";
    }

    @Override
    public List<ReservaOutputDTO> getReservasList(String id_bus) {
        BusEntity bus = busRepository.findById(id_bus).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );
        System.out.println(bus);
        List<ReservaEntity> reserva = reservasRepository.findByIdBus(bus.getIdBus());
        System.out.println(reserva);
        List<ReservaOutputDTO> reservaOutputDTOS = new ArrayList<>();

        for (ReservaEntity r: reserva){
            ReservaOutputDTO reservaOutputDTO = new ReservaOutputDTO(r,bus);
            reservaOutputDTOS.add(reservaOutputDTO);
        }

        return reservaOutputDTOS;
    }


}
