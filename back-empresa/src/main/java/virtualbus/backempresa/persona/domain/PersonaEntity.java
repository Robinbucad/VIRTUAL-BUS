package virtualbus.backempresa.persona.domain;

import lombok.Data;
import virtualbus.backempresa.persona.infraestructure.controller.input.PersonaInputDTO;

import javax.persistence.*;

@Data
@Entity(name = "personas")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private PersonaRoles personaRoles;

    public PersonaEntity(PersonaInputDTO persona){
        setNombre(persona.getNombre());
        setApellidos(persona.getApellidos());
        setEmail(persona.getEmail());
        setTelefono(persona.getTelefono());
        setUsername(persona.getUsername());
        setPassword(persona.getPassword());
        setPersonaRoles(PersonaRoles.USER);
    }
    public PersonaEntity(){}
}
