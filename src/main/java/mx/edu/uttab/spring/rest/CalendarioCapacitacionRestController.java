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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uttab.spring.model.CalendarioCapacitacion;
import mx.edu.uttab.spring.service.CalendarioCapacitacionService;

@RestController
public class CalendarioCapacitacionRestController {
	private CalendarioCapacitacionService calendarioCapacitacionService;

	@Autowired(required = true)
	@Qualifier(value = "calendarioCapacitacionService")
	public void setCalendarioCapacitacionService(CalendarioCapacitacionService calendarioCapacitacionService) {
		this.calendarioCapacitacionService = calendarioCapacitacionService;
	}

	@RequestMapping(value = "/rest/calendariocapacitaciones", method = RequestMethod.GET)
	public ResponseEntity<List<CalendarioCapacitacion>> listAllCalendarioCapacitacionByCapacitacion(@RequestParam(value = "c", defaultValue = "1") int capacitacion_id) {
		List<CalendarioCapacitacion> listCalendarioCapacitacion = calendarioCapacitacionService.listCalendarioCapacitacionByCapacitacion(capacitacion_id);
		if (listCalendarioCapacitacion.isEmpty()) {
			return new ResponseEntity<List<CalendarioCapacitacion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CalendarioCapacitacion>>(listCalendarioCapacitacion, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rest/calendariocapacitaciones/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CalendarioCapacitacion calendarioCapacitacionById(@PathVariable("id") int id) {
		CalendarioCapacitacion calendarioCapacitacion = calendarioCapacitacionService.getCalendarioCapacitacionById(id);
        return calendarioCapacitacion;
	}

}
