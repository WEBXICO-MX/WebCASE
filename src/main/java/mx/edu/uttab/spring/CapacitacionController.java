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

import mx.edu.uttab.spring.model.Capacitacion;
import mx.edu.uttab.spring.service.CapacitacionService;
import mx.edu.uttab.spring.service.TipoCapacitacionService;

@Controller
public class CapacitacionController {
	private CapacitacionService capacitacionService;
	private TipoCapacitacionService tipoCapacitacionService;

	@Autowired(required = true)
	@Qualifier(value = "capacitacionService")
	public void setCapacitacionService(CapacitacionService capacitacionService) {
		this.capacitacionService = capacitacionService;
	}

	@Autowired(required = true)
	@Qualifier(value = "tipoCapacitacionService")
	public void setTipoCapacitacionService(TipoCapacitacionService tipoCapacitacionService) {
		this.tipoCapacitacionService = tipoCapacitacionService;
	}

	@RequestMapping(value = "/capacitaciones", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listCapacitacion", this.capacitacionService.listCapacitacion());
		return "capacitaciones/index";
	}

	@RequestMapping(value = "/capacitaciones/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("capacitacion", new Capacitacion());
		model.addAttribute("listTipoCapacitacion", this.tipoCapacitacionService.listTipoCapacitacion());
		return "capacitaciones/create";
	}

	@RequestMapping(value = "/capacitaciones/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("capacitacion") Capacitacion c) {

		if (c.getId() == 0) {
			// new person, add it
			this.capacitacionService.addCapacitacion(c);
			;
		} else {
			// existing person, call update
			this.capacitacionService.updateCapacitacion(c);
		}

		return "redirect:/capacitaciones";

	}

	@RequestMapping("/capacitaciones/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("capacitacion", this.capacitacionService.getCapacitacionById(id));
		model.addAttribute("listTipoCapacitacion", this.tipoCapacitacionService.listTipoCapacitacion());
		return "capacitaciones/edit";
	}

	@RequestMapping("/capacitaciones/{id}/destroy")
	public String destroy(@PathVariable("id") int id) {
		this.capacitacionService.removeCapacitacion(id);
		;
		return "redirect:/capacitaciones";
	}

}
