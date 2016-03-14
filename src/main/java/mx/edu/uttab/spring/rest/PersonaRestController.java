package mx.edu.uttab.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import mx.edu.uttab.spring.model.Persona;
import mx.edu.uttab.spring.service.PersonaService;

@RestController
public class PersonaRestController {
	private PersonaService personaService;

	@Autowired(required = true)
	@Qualifier(value = "personaService")
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@RequestMapping(value = "/rest/persona", method = RequestMethod.POST)
	public ResponseEntity<Void> createPersona(@RequestBody Persona p, UriComponentsBuilder ucBuilder) {
System.out.println("Entre a /rest/persona");
		personaService.addPersona(p);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/personas/{id}").buildAndExpand(p.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}
