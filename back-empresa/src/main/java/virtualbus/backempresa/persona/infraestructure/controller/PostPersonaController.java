package virtualbus.backempresa.persona.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.backempresa.persona.application.PersonaService;
import virtualbus.backempresa.persona.infraestructure.controller.input.PersonaInputDTO;
import virtualbus.backempresa.persona.infraestructure.controller.output.PersonaOutputDTO;

@RequestMapping("/api/v0")
@RestController
public class PostPersonaController {

    @Autowired
    PersonaService personaService;

    @PostMapping("/personas")
    public ResponseEntity<PersonaOutputDTO> createPersona(@RequestBody PersonaInputDTO personaInputDTO){
        PersonaOutputDTO personaOutputDTO = personaService.createPersona(personaInputDTO);
        return ResponseEntity.ok(personaOutputDTO);
    }

}
