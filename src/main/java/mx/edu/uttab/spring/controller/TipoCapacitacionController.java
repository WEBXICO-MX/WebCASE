/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uttab.spring.model.SectorProductivo;
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

	 @RequestMapping(value = "/rest/tiposcapacitaciones", method = RequestMethod.GET)
	    public ResponseEntity<List<TipoCapacitacion>> listAllTipoCapacitacions() {
	        List<TipoCapacitacion> listTipoCapacitacion = tipoCapacitacionService.listTipoCapacitacion();
	        if(listTipoCapacitacion.isEmpty()){
	            return new ResponseEntity<List<TipoCapacitacion>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<TipoCapacitacion>>(listTipoCapacitacion, HttpStatus.OK);
	    }
	
	@RequestMapping(value = "/tiposcapacitaciones", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listTipoCapacitacion", this.tipoCapacitacionService.listTipoCapacitacion());
		return "tipoCapacitacion/index";
	}

	@RequestMapping(value = "/tiposcapacitaciones/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("tipoCapacitacion", new TipoCapacitacion());
		return "tipoCapacitacion/create";
	}

	@RequestMapping(value = "/tiposcapacitaciones/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("tipoCapacitacion") TipoCapacitacion tc) {

		if (tc.getId() == 0) {
			// new person, add it
			this.tipoCapacitacionService.addTipoCapacitacion(tc);
		} else {
			// existing person, call update
			this.tipoCapacitacionService.updateTipoCapacitacion(tc);
		}

		return "redirect:/tiposcapacitaciones";

	}

	@RequestMapping("/tiposcapacitaciones/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("tipoCapacitacion", this.tipoCapacitacionService.getTipoCapacitacionById(id));
		return "tipoCapacitacion/edit";
	}
	
	@RequestMapping("/tiposcapacitaciones/{id}/destroy")
	public String destroy(@PathVariable("id") int id) {
		this.tipoCapacitacionService.removeTipoCapacitacion(id);
		return "redirect:/tiposcapacitaciones";
	}

}
