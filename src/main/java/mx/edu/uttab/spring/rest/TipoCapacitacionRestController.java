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
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uttab.spring.model.TipoCapacitacion;
import mx.edu.uttab.spring.service.TipoCapacitacionService;

@RestController
public class TipoCapacitacionRestController {

	private TipoCapacitacionService tipoCapacitacionService;

	@Autowired(required = true)
	@Qualifier(value = "tipoCapacitacionService")
	public void setTipoCapacitacionService(TipoCapacitacionService tipoCapacitacionService) {
		this.tipoCapacitacionService = tipoCapacitacionService;
	}

	@RequestMapping(value = "/rest/tiposcapacitaciones", method = RequestMethod.GET)
	public ResponseEntity<List<TipoCapacitacion>> listAllTipoCapacitacions() {
		List<TipoCapacitacion> listTipoCapacitacion = tipoCapacitacionService.listTipoCapacitacion();
		if (listTipoCapacitacion.isEmpty()) {
			return new ResponseEntity<List<TipoCapacitacion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TipoCapacitacion>>(listTipoCapacitacion, HttpStatus.OK);
	}

}
