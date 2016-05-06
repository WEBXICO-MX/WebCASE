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

import mx.edu.uttab.spring.model.CalendarioCapacitacion;
import mx.edu.uttab.spring.service.CalendarioCapacitacionService;
import mx.edu.uttab.spring.service.CapacitacionService;

@Controller
public class CalendarioCapacitacionController {
	private CalendarioCapacitacionService calendarioCapacitacionService;
	private CapacitacionService capacitacionService;

	@Autowired(required = true)
	@Qualifier(value = "calendarioCapacitacionService")
	public void setCalendarioCapacitacionService(CalendarioCapacitacionService calendarioCapacitacionService) {
		this.calendarioCapacitacionService = calendarioCapacitacionService;
	}

	@Autowired(required = true)
	@Qualifier(value = "capacitacionService")
	public void setCapacitacionService(CapacitacionService capacitacionService) {
		this.capacitacionService = capacitacionService;
	}

	@RequestMapping(value = "/calendarioscapacitaciones", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("listCalendarioCapacitacion",
					this.calendarioCapacitacionService.listCalendarioCapacitacion());
			return "calendarioCapacitacion/index";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/calendarioscapacitaciones/new", method = RequestMethod.GET)
	public String create(Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("calendarioCapacitacion", new CalendarioCapacitacion());
			model.addAttribute("listCapacitacion", this.capacitacionService.listCapacitacion());
			return "calendarioCapacitacion/create";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/calendarioscapacitaciones/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("calendarioCapacitacion") CalendarioCapacitacion cc,
			HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			if (cc.getId() == 0) {
				// new person, add it
				this.calendarioCapacitacionService.addCalendarioCapacitacion(cc);
				;
			} else {
				// existing person, call update
				this.calendarioCapacitacionService.updateCalendarioCapacitacion(cc);
			}

			return "redirect:/calendarioscapacitaciones";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/calendarioscapacitaciones/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("calendarioCapacitacion",
					this.calendarioCapacitacionService.getCalendarioCapacitacionById(id));
			model.addAttribute("listCapacitacion", this.capacitacionService.listCapacitacion());
			return "calendarioCapacitacion/edit";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/calendarioscapacitaciones/{id}/destroy")
	public String destroy(@PathVariable("id") int id, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			this.calendarioCapacitacionService.removeCalendarioCapacitacion(id);
			return "redirect:/calendarioscapacitaciones";
		} else {
			return "redirect:/";
		}

	}

}
