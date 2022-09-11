package virtualbus.backempresa.persona.infraestructure.controller.output;

import lombok.Data;
import virtualbus.backempresa.persona.domain.PersonaEntity;

@Data
public class PersonaOutputDTO {

    private Long idPersona;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String username;
    private String password;

    public PersonaOutputDTO(PersonaEntity persona){
        setIdPersona(persona.getIdPersona());
        setNombre(persona.getNombre());
        setApellidos(persona.getApellidos());
        setEmail(persona.getEmail());
        setTelefono(persona.getTelefono());
        setUsername(persona.getUsername());
        setPassword(persona.getPassword());
    }

    public PersonaOutputDTO(){}

}
