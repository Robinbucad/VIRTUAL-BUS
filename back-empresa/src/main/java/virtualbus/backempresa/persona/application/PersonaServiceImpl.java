package virtualbus.backempresa.persona.application;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import virtualbus.backempresa.persona.domain.PersonaEntity;
import virtualbus.backempresa.persona.domain.PersonaRoles;
import virtualbus.backempresa.persona.infraestructure.controller.input.PersonaInputDTO;
import virtualbus.backempresa.persona.infraestructure.controller.output.PersonaOutputDTO;
import virtualbus.backempresa.persona.infraestructure.repository.PersonaRepository;
import virtualbus.backempresa.utils.exception.unprocessable.UnprocessableException;


import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService, UserDetailsService {

    @Autowired
    PersonaRepository personaRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public PersonaOutputDTO createPersona(PersonaInputDTO personaInputDTO) {
        PersonaEntity checkPersona = personaRepository.findByEmail(personaInputDTO.getEmail()).orElse(null);
        if (checkPersona != null) throw new UnprocessableException("Esta persona ya esta registrada");

        PersonaEntity persona = new PersonaEntity(personaInputDTO);
        persona.setPassword(passwordEncoder.encode(personaInputDTO.getPassword()));
        personaRepository.save(persona);
        return new PersonaOutputDTO(persona);
    }

    @Override
    public PersonaOutputDTO getPersonaById(Long id) {
        PersonaEntity persona = personaRepository.findById(id).orElse(null);
        return new PersonaOutputDTO(persona);
    }

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        PersonaEntity persona = personaRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Persona no existe o datos incorrectos"));
        PersonaRoles roles = persona.getPersonaRoles();
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roles.name()));

        return new org.springframework.security.core.userdetails.User(persona.getUsername(),persona.getPassword(), authorities);
    }
}
