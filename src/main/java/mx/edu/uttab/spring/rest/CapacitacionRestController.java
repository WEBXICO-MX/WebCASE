/**
*
* @author Roberto Eder Weiss Juárez
* @see {@link http://webxico.blogspot.mx/}
*/
package mx.edu.uttab.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uttab.spring.model.Capacitacion;
import mx.edu.uttab.spring.service.CapacitacionService;

@RestController
public class CapacitacionRestController {
	private CapacitacionService capacitacionService;

	@Autowired(required = true)
	@Qualifier(value = "capacitacionService")
	public void setCapacitacionService(CapacitacionService capacitacionService) {
		this.capacitacionService = capacitacionService;
	}

	@RequestMapping(value = "/rest/capacitaciones", method = RequestMethod.GET)
	public ResponseEntity<List<Capacitacion>> listAllCapacitacions(
			@RequestParam(value = "tp", defaultValue = "1") int tipo) {
		List<Capacitacion> listCapacitacion = capacitacionService.listCapacitacionByTipo(tipo);
		if (listCapacitacion.isEmpty()) {
			return new ResponseEntity<List<Capacitacion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Capacitacion>>(listCapacitacion, HttpStatus.OK);
	}

}
