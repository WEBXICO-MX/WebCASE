/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.uttab.spring.model.TipoCapacitacion;
import mx.edu.uttab.spring.service.TipoCapacitacionService;

@Controller
public class TipoCapacitacionController {

	private TipoCapacitacionService tipoCapacitacionService;

	@Autowired(required = true)
	@Qualifier(value = "tipoCapacitacionService")
	public void setTipoCapacitacionService(TipoCapacitacionService tipoCapacitacionService) {
		this.tipoCapacitacionService = tipoCapacitacionService;
	}

	@RequestMapping(value = "/tiposcapacitaciones", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("listTipoCapacitacion", this.tipoCapacitacionService.listTipoCapacitacion());
			return "tipoCapacitacion/index";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/tiposcapacitaciones/new", method = RequestMethod.GET)
	public String create(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("tipoCapacitacion", new TipoCapacitacion());
			return "tipoCapacitacion/create";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/tiposcapacitaciones/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("tipoCapacitacion") TipoCapacitacion tc, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			if (tc.getId() == 0) {
				// new person, add it
				this.tipoCapacitacionService.addTipoCapacitacion(tc);
			} else {
				// existing person, call update
				this.tipoCapacitacionService.updateTipoCapacitacion(tc);
			}

			return "redirect:/tiposcapacitaciones";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/tiposcapacitaciones/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("tipoCapacitacion", this.tipoCapacitacionService.getTipoCapacitacionById(id));
			return "tipoCapacitacion/edit";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/tiposcapacitaciones/{id}/destroy")
	public String destroy(@PathVariable("id") int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			this.tipoCapacitacionService.removeTipoCapacitacion(id);
			return "redirect:/tiposcapacitaciones";
		} else {
			return "redirect:/";
		}

	}

}
