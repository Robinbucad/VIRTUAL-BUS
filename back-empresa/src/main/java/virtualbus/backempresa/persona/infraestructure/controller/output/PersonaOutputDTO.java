package virtualbus.backempresa.persona.infraestructure.controller.output;

import lombok.Data;
import virtualbus.backempresa.persona.domain.PersonaEntity;

@Data
public class PersonaOutputDTO {

    private Long idPersona;
    private String username;
    private String password;

    public PersonaOutputDTO(PersonaEntity persona){
        setIdPersona(persona.getIdPersona());
        setUsername(persona.getUsername());
        setPassword(persona.getPassword());
    }

    public PersonaOutputDTO(){}

}
