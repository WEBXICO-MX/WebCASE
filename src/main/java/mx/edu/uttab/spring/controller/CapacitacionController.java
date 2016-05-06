/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.controller;

import javax.servlet.http.HttpSession;

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
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("listCapacitacion", this.capacitacionService.listCapacitacion());
			return "capacitaciones/index";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/capacitaciones/new", method = RequestMethod.GET)
	public String create(Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("capacitacion", new Capacitacion());
			model.addAttribute("listTipoCapacitacion", this.tipoCapacitacionService.listTipoCapacitacion());
			return "capacitaciones/create";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/capacitaciones/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("capacitacion") Capacitacion c, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			if (c.getId() == 0) {
				// new person, add it
				this.capacitacionService.addCapacitacion(c);
				;
			} else {
				// existing person, call update
				this.capacitacionService.updateCapacitacion(c);
			}

			return "redirect:/capacitaciones";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/capacitaciones/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("capacitacion", this.capacitacionService.getCapacitacionById(id));
			model.addAttribute("listTipoCapacitacion", this.tipoCapacitacionService.listTipoCapacitacion());
			return "capacitaciones/edit";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/capacitaciones/{id}/destroy")
	public String destroy(@PathVariable("id") int id, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			this.capacitacionService.removeCapacitacion(id);
			return "redirect:/capacitaciones";
		} else {
			return "redirect:/";
		}

	}

}
