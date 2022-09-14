package virtualbus.persona.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.persona.application.PersonaService;
import virtualbus.persona.infraestructure.controller.input.PersonaInputDTO;
import virtualbus.persona.infraestructure.controller.output.PersonaOutputDTO;

@RequestMapping("/api/v0/personas")
@RestController
public class PostPersonaController {

    @Autowired
    PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaOutputDTO> createPersona(@RequestBody PersonaInputDTO personaInputDTO){
        PersonaOutputDTO personaOutputDTO = personaService.createPersona(personaInputDTO);
        return ResponseEntity.ok(personaOutputDTO);
    }

}
