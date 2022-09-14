package virtualbus.backempresa.reserva.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virtualbus.backempresa.bus.domain.BusEntity;
import virtualbus.backempresa.bus.infraestructure.repository.BusRepository;
import virtualbus.backempresa.kafka.ReservaProducer;
import virtualbus.backempresa.reserva.domain.ReservaEntity;
import virtualbus.backempresa.reserva.domain.ReservaStatus;
import virtualbus.backempresa.reserva.infraestructure.controller.dto.input.ReservaInputDTO;
import virtualbus.backempresa.reserva.infraestructure.controller.dto.output.ReservaOutputDTO;
import virtualbus.backempresa.reserva.infraestructure.repository.ReservasRepository;
import virtualbus.backempresa.reservaDIsponible.domain.ReservaDisponibleEntity;
import virtualbus.backempresa.reservaDIsponible.infraestructure.repository.ReservasDisponiblesRepository;
import virtualbus.backempresa.utils.exception.notFound.NotFoundException;
import virtualbus.backempresa.utils.exception.unprocessable.UnprocessableException;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReservaServiceImpl implements ReservaService {

    private ReservaProducer reservaProducer;

    @Autowired
    ReservasRepository reservasRepository;

    @Autowired
    BusRepository busRepository;

    @Autowired
    ReservasDisponiblesRepository reservasDisponiblesRepository;


    public ReservaServiceImpl(ReservaProducer reservaProducer) {
        this.reservaProducer = reservaProducer;
    }

    @Override
    public List<ReservaOutputDTO> getAllReservas(String token) {

        String checkToken = "Token válido";  //reservasRealizadasClient.checkToken(token).getBody();
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
        ReservaEntity checkReserva = reservasRepository.findBycorreoElectronico(reservaInputDTO.getCorreoElectronico()).orElse(null);
        if (checkReserva != null) throw new UnprocessableException("El usuario ya ha realizado una reserva");
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
        reservaProducer.sendMessageToReservas(bus.getIdBus());
        reservaProducer.sendMessageToEmails(reserva.getCorreoElectronico());
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

    @Override
    public String cancelReserva(String id_reserva) {
        ReservaEntity reserva = reservasRepository.findById(id_reserva).orElseThrow(
                () -> new NotFoundException("Reserva no existe")
        );
        BusEntity bus = busRepository.findById(reserva.getIdBus()).orElseThrow(
                ()-> new NotFoundException("Bus no existe")
        );
        ReservaDisponibleEntity reservaDisponible = reservasDisponiblesRepository.findReservaDisponibleByIdBus(bus.getIdBus()).orElseThrow(
                () -> new NotFoundException("ReservaDisponible no existente")
        );
        reserva.setStatus(ReservaStatus.CANCELADO);
        reservaProducer.sendMessageToReservas(bus.getIdBus());
        reservaProducer.sendMessageToEmails(reserva.getCorreoElectronico());
        bus.setPlazas(bus.getPlazas()+1);
        reservaDisponible.setNumeroPlazas(bus.getPlazas()+1);
        reservasRepository.delete(reserva);
        reservasDisponiblesRepository.save(reservaDisponible);


        return "Su reserva se ha cancelado";
    }


}
