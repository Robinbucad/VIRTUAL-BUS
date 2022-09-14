package virtualbus.backempresa.persona.infraestructure.controller.input;

import lombok.Data;

import javax.persistence.*;

@Data
public class PersonaInputDTO {

    private String username;
    private String password;
}
