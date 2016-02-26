/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.uttab.spring.model.Persona;
import mx.edu.uttab.spring.service.PersonaService;

@Controller
public class PersonaController {
	private PersonaService personaService;

	@Autowired(required = true)
	@Qualifier(value = "personaService")
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@RequestMapping(value = "/personas", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listPersona", this.personaService.listPersona());
		return "personas/index";
	}

	@RequestMapping(value = "/personas/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("persona", new Persona());
		return "personas/create";
	}

	@RequestMapping(value = "/personas/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("persona") Persona p) {

		if (p.getId() == 0) {
			// new person, add it
			this.personaService.addPersona(p);
		} else {
			// existing person, call update
			this.personaService.updatePersona(p);
		}

		return "redirect:/personas";

	}

	@RequestMapping("/personas/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("persona", this.personaService.getPersonaById(id));
		return "personas/edit";
	}

	@RequestMapping("/personas/{id}/destroy")
	public String destroy(@PathVariable("id") int id) {
		this.personaService.removePersona(id);
		return "redirect:/personas";
	}

}
