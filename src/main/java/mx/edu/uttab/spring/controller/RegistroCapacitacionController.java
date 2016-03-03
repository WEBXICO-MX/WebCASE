/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.uttab.spring.model.RegistroCapacitacion;
import mx.edu.uttab.spring.service.RegistroCapacitacionService;
import mx.edu.uttab.spring.service.StatusService;
import mx.edu.uttab.spring.service.CalendarioCapacitacionService;
import mx.edu.uttab.spring.service.EmpresaService;
import mx.edu.uttab.spring.service.PersonaService;
import mx.edu.uttab.spring.service.TipoInscripcionService;
@Controller
public class RegistroCapacitacionController {
	private RegistroCapacitacionService registroCapacitacionService;
	private CalendarioCapacitacionService calendarioCapacitacionService;
	private TipoInscripcionService tipoInscripcionService;
	private PersonaService personaService;
	private EmpresaService empresaService;
	private StatusService statusService;

	@Autowired(required = true)
	@Qualifier(value = "registroCapacitacionService")
	public void setRegistroCapacitacionService(RegistroCapacitacionService registroCapacitacionService) {
		this.registroCapacitacionService = registroCapacitacionService;
	}

	@Autowired(required = true)
	@Qualifier(value = "calendarioCapacitacionService")
	public void setCalendarioCapacitacionService(CalendarioCapacitacionService calendarioCapacitacionService) {
		this.calendarioCapacitacionService = calendarioCapacitacionService;
	}

	@Autowired(required = true)
	@Qualifier(value = "tipoInscripcionService")
	public void setTipoInscripcionService(TipoInscripcionService tipoInscripcionService) {
		this.tipoInscripcionService = tipoInscripcionService;
	}

	@Autowired(required = true)
	@Qualifier(value = "personaService")
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@Autowired(required = true)
	@Qualifier(value = "empresaService")
	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@Autowired(required = true)
	@Qualifier(value = "statusService")
	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

	@RequestMapping(value = "/registroscapacitaciones", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listRegistroCapacitacion", this.registroCapacitacionService.listRegistroCapacitacion());
		return "registroCapacitaciones/index";
	}

	@RequestMapping(value = "/registroscapacitaciones/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("registroCapacitacion", new RegistroCapacitacion());
		model.addAttribute("listCalendarioCapacitacion",this.calendarioCapacitacionService.listCalendarioCapacitacion());
		model.addAttribute("listTipoInscripcion", this.tipoInscripcionService.listTipoInscripcions());
		model.addAttribute("listPersona", this.personaService.listPersona());
		model.addAttribute("listEmpresa", this.empresaService.listEmpresa());
		model.addAttribute("listStatus", this.statusService.listStatuss());
		return "registroCapacitaciones/create";
	}

	@RequestMapping(value = "/registroscapacitaciones/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("registroCapacitacion") RegistroCapacitacion rc) {

		if (rc.getId() == 0) {
			// new person, add it
			this.registroCapacitacionService.addRegistroCapacitacion(rc);
		} else {
			// existing person, call update
			this.registroCapacitacionService.updateRegistroCapacitacion(rc);
		}

		return "redirect:/registroscapacitaciones";

	}

	@RequestMapping("/registroscapacitaciones/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("registroCapacitacion", this.registroCapacitacionService.getRegistroCapacitacionById(id));
		model.addAttribute("listCalendarioCapacitacion",this.calendarioCapacitacionService.listCalendarioCapacitacion());
		model.addAttribute("listTipoInscripcion", this.tipoInscripcionService.listTipoInscripcions());
		model.addAttribute("listPersona", this.personaService.listPersona());
		model.addAttribute("listEmpresa", this.empresaService.listEmpresa());
		model.addAttribute("listStatus", this.statusService.listStatuss());
		return "registroCapacitaciones/edit";
	}

	@RequestMapping("/registroscapacitaciones/{id}/destroy")
	public String destroy(@PathVariable("id") int id) {
		this.registroCapacitacionService.removeRegistroCapacitacion(id);
		return "redirect:/registroscapacitaciones";
	}
}