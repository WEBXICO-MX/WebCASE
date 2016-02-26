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

import mx.edu.uttab.spring.model.MedioComunicacion;
import mx.edu.uttab.spring.service.MedioComunicacionService;
import mx.edu.uttab.spring.service.PersonaService;
import mx.edu.uttab.spring.service.TipoMedioComunicacionService;

@Controller
public class MedioComunicacionController {
	private MedioComunicacionService medioComunicacionService;
	private PersonaService personaService;
	private TipoMedioComunicacionService tipoMedioComunicacionService;

	@Autowired(required = true)
	@Qualifier(value = "medioComunicacionService")
	public void setMedioComunicacionService(MedioComunicacionService medioComunicacionService) {
		this.medioComunicacionService = medioComunicacionService;
	}

	@Autowired(required = true)
	@Qualifier(value = "personaService")
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@Autowired(required = true)
	@Qualifier(value = "tipoMedioComunicacionService")
	public void setTipoMedioComunicacionService(TipoMedioComunicacionService tipoMedioComunicacionService) {
		this.tipoMedioComunicacionService = tipoMedioComunicacionService;
	}

	@RequestMapping(value = "/medioscomunicacion", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listMedioComunicacion", this.medioComunicacionService.listMedioComunicacion());
		return "mediosComunicacion/index";
	}

	@RequestMapping(value = "/medioscomunicacion/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("medioComunicacion", new MedioComunicacion());
		model.addAttribute("listPersona", this.personaService.listPersona());
		model.addAttribute("listTipoMedioComunicacion", this.tipoMedioComunicacionService.listTipoMedioComunicacions());
		return "mediosComunicacion/create";
	}

	@RequestMapping(value = "/medioscomunicacion/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("medioComunicacion") MedioComunicacion mc) {

		if (mc.getId() == 0) {
			// new person, add it
			this.medioComunicacionService.addMedioComunicacion(mc);
		} else {
			// existing person, call update
			this.medioComunicacionService.updateMedioComunicacion(mc);
		}

		return "redirect:/medioscomunicacion";

	}

	@RequestMapping("/medioscomunicacion/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("medioComunicacion", this.medioComunicacionService.getMedioComunicacionById(id));
		model.addAttribute("listPersona", this.personaService.listPersona());
		model.addAttribute("listTipoMedioComunicacion", this.tipoMedioComunicacionService.listTipoMedioComunicacions());
		return "mediosComunicacion/edit";
	}

	@RequestMapping("/medioscomunicacion/{id}/destroy")
	public String destroy(@PathVariable("id") int id) {
		this.medioComunicacionService.removeMedioComunicacion(id);
		return "redirect:/medioscomunicacion";
	}

}
