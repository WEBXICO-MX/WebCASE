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

import mx.edu.uttab.spring.model.TipoInscripcion;
import mx.edu.uttab.spring.service.TipoInscripcionService;

@Controller
public class TipoInscripcionController {
	private TipoInscripcionService tipoInscripcionService;

	@Autowired(required = true)
	@Qualifier(value = "tipoInscripcionService")
	public void setTipoInscripcionService(TipoInscripcionService tipoInscripcionService) {
		this.tipoInscripcionService = tipoInscripcionService;
	}

	@RequestMapping(value = "/tiposinscripciones", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("listTipoInscripcion", this.tipoInscripcionService.listTipoInscripcions());
			return "tipoInscripcion/index";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/tiposinscripciones/new", method = RequestMethod.GET)
	public String create(Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("tipoInscripcion", new TipoInscripcion());
			return "tipoInscripcion/create";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/tiposinscripciones/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("tipoInscripcion") TipoInscripcion ti, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			if (ti.getId() == 0) {
				// new person, add it
				this.tipoInscripcionService.addTipoInscripcion(ti);
			} else {
				// existing person, call update
				this.tipoInscripcionService.updateTipoInscripcion(ti);
			}

			return "redirect:/tiposinscripciones";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/tiposinscripciones/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("tipoInscripcion", this.tipoInscripcionService.getTipoInscripcionById(id));
			return "tipoInscripcion/edit";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/tiposinscripciones/{id}/destroy")
	public String destroy(@PathVariable("id") int id, HttpSession session) {
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			this.tipoInscripcionService.removeTipoInscripcion(id);
			return "redirect:/tiposinscripciones";
		} else {
			return "redirect:/";
		}

	}

}
