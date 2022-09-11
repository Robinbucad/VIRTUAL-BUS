package virtualbus.backempresa.persona.application;

import virtualbus.backempresa.persona.infraestructure.controller.input.PersonaInputDTO;
import virtualbus.backempresa.persona.infraestructure.controller.output.PersonaOutputDTO;

public interface PersonaService {
    PersonaOutputDTO createPersona(PersonaInputDTO personaInputDTO);
    PersonaOutputDTO getPersonaById(Long id);
}
