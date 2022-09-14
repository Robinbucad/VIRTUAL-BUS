package virtualbus.persona.domain;

import lombok.Data;
import virtualbus.persona.infraestructure.controller.input.PersonaInputDTO;

import javax.persistence.*;

@Data
@Entity(name = "personas")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private PersonaRoles personaRoles;

    public PersonaEntity(PersonaInputDTO persona){
        setUsername(persona.getUsername());
        setPassword(persona.getPassword());
        setPersonaRoles(PersonaRoles.USER);
    }
    public PersonaEntity(){}
}
