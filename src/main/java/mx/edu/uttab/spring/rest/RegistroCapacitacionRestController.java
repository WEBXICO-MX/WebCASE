package mx.edu.uttab.spring.rest;

/**
*
* @author Roberto Eder Weiss Juárez
* @see {@link http://webxico.blogspot.mx/}
*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uttab.spring.model.RegistroCapacitacion;
import mx.edu.uttab.spring.service.RegistroCapacitacionService;

/**
 * @author Weiss
 *
 */
@RestController
public class RegistroCapacitacionRestController {
	private RegistroCapacitacionService registroCapacitacionService;

	@Autowired(required = true)
	@Qualifier(value = "registroCapacitacionService")
	public void setRegistroCapacitacionService(RegistroCapacitacionService registroCapacitacionService) {
		this.registroCapacitacionService = registroCapacitacionService;
	}

	@RequestMapping(value = "/rest/registrocapacitaciones", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroCapacitacion>> listAllRegistroCapacitacions(@RequestParam(value="sts", defaultValue="1") int status) {

		List<RegistroCapacitacion> listRegistroCapacitacion = registroCapacitacionService.listRegistroCapacitacionByStatus(status);
		if (listRegistroCapacitacion.isEmpty()) {
			return new ResponseEntity<List<RegistroCapacitacion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RegistroCapacitacion>>(listRegistroCapacitacion, HttpStatus.OK);
	}

}
