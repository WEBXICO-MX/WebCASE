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

import mx.edu.uttab.spring.model.TipoMedioComunicacion;
import mx.edu.uttab.spring.service.TipoMedioComunicacionService;

@Controller
public class TipoMedioComunicacionController {
	private TipoMedioComunicacionService tipoMedioComunicacionService;

	@Autowired(required = true)
	@Qualifier(value = "tipoMedioComunicacionService")
	public void setTipoMedioComunicacionService(TipoMedioComunicacionService tipoMedioComunicacionService) {
		this.tipoMedioComunicacionService = tipoMedioComunicacionService;
	}

	@RequestMapping(value = "/tiposmedioscomunicacion", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listTipoMedioComunicacion", this.tipoMedioComunicacionService.listTipoMedioComunicacions());
		return "tipoMedioComunicacion/index";
	}

	@RequestMapping(value = "/tiposmedioscomunicacion/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("tipoMedioComunicacion", new TipoMedioComunicacion());
		return "tipoMedioComunicacion/create";
	}

	@RequestMapping(value = "/tiposmedioscomunicacion/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("tipoMedioComunicacion") TipoMedioComunicacion tmc) {

		if (tmc.getId() == 0) {
			// new person, add it
			this.tipoMedioComunicacionService.addTipoMedioComunicacion(tmc);
		} else {
			// existing person, call update
			this.tipoMedioComunicacionService.updateTipoMedioComunicacion(tmc);
		}

		return "redirect:/tiposmedioscomunicacion";

	}

	@RequestMapping("/tiposmedioscomunicacion/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("tipoMedioComunicacion", this.tipoMedioComunicacionService.getTipoMedioComunicacionById(id));
		return "tipoMedioComunicacion/edit";
	}

	@RequestMapping("/tiposmedioscomunicacion/{id}/destroy")
	public String destroy(@PathVariable("id") int id) {
		this.tipoMedioComunicacionService.removeTipoMedioComunicacion(id);
		return "redirect:/tiposmedioscomunicacion";
	}

}