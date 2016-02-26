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
	public String index(Model model) {
		model.addAttribute("listTipoInscripcion", this.tipoInscripcionService.listTipoInscripcions());
		return "tipoInscripcion/index";
	}

	@RequestMapping(value = "/tiposinscripciones/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("tipoInscripcion", new TipoInscripcion());
		return "tipoInscripcion/create";
	}

	@RequestMapping(value = "/tiposinscripciones/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("tipoInscripcion") TipoInscripcion ti) {

		if (ti.getId() == 0) {
			// new person, add it
			this.tipoInscripcionService.addTipoInscripcion(ti);
		} else {
			// existing person, call update
			this.tipoInscripcionService.updateTipoInscripcion(ti);
		}

		return "redirect:/tiposinscripciones";

	}

	@RequestMapping("/tiposinscripciones/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("tipoInscripcion", this.tipoInscripcionService.getTipoInscripcionById(id));
		return "tipoInscripcion/edit";
	}

	@RequestMapping("/tiposinscripciones/{id}/destroy")
	public String destroy(@PathVariable("id") int id) {
		this.tipoInscripcionService.removeTipoInscripcion(id);
		;
		return "redirect:/tiposinscripciones";
	}

}
