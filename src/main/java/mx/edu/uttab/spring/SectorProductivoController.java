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

import mx.edu.uttab.spring.model.SectorProductivo;
import mx.edu.uttab.spring.model.TipoCapacitacion;
import mx.edu.uttab.spring.service.SectorProductivoService;

@Controller
public class SectorProductivoController {

	private SectorProductivoService sectorProductivoService;

	@Autowired(required = true)
	@Qualifier(value = "sectorProductivoService")
	public void setSectorProductivoService(SectorProductivoService sectorProductivoService) {
		this.sectorProductivoService = sectorProductivoService;
	}

	@RequestMapping(value = "/sectoresproductivos", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listSectorProductivo", this.sectorProductivoService.listSectorProductivos());
		return "sectorProductivo/index";
	}

	@RequestMapping(value = "/sectoresproductivos/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("sectorProductivo", new SectorProductivo());
		return "sectorProductivo/create";
	}

	@RequestMapping(value = "/sectoresproductivos/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("sectorProductivo") SectorProductivo sp) {

		if (sp.getId() == 0) {
			this.sectorProductivoService.addSectorProductivo(sp);
		} else {
			this.sectorProductivoService.updateSectorProductivo(sp);
		}

		return "redirect:/sectoresproductivos";

	}

	@RequestMapping("/sectoresproductivos/{id}/edit")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("sectorProductivo", this.sectorProductivoService.getSectorProductivoById(id));
		model.addAttribute("listSectorProductivo", this.sectorProductivoService.listSectorProductivos());
		return "sectorProductivo/edit";
	}

	@RequestMapping("/sectoresproductivos/{id}/destroy")
	public String removePerson(@PathVariable("id") int id) {

		this.sectorProductivoService.removeSectorProductivo(id);
		return "redirect:/sectoresproductivos";
	}

}
