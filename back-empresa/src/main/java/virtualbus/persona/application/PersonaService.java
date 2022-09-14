package virtualbus.persona.application;

import virtualbus.persona.infraestructure.controller.input.PersonaInputDTO;
import virtualbus.persona.infraestructure.controller.output.PersonaOutputDTO;

public interface PersonaService {
    PersonaOutputDTO createPersona(PersonaInputDTO personaInputDTO);
    PersonaOutputDTO getPersonaById(Long id);
}
