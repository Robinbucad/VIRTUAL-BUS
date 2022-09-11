package virtualbus.backempresa.persona.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import virtualbus.backempresa.persona.application.PersonaService;
import virtualbus.backempresa.persona.infraestructure.controller.output.PersonaOutputDTO;

@RequestMapping("/api/v0/personas")
@RestController
public class GetPersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDTO> getPersonaById(@PathVariable Long id){
        PersonaOutputDTO personaOutputDTO = personaService.getPersonaById(id);
        return ResponseEntity.ok(personaOutputDTO);
    }
}
