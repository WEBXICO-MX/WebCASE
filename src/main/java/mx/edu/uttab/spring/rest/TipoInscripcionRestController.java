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
import mx.edu.uttab.spring.model.TipoInscripcion;
import mx.edu.uttab.spring.service.TipoInscripcionService;

@RestController
public class TipoInscripcionRestController {

	private TipoInscripcionService tipoInscripcionService;

	@Autowired(required = true)
	@Qualifier(value = "tipoInscripcionService")
	public void setTipoInscripcionService(TipoInscripcionService tipoInscripcionService) {
		this.tipoInscripcionService = tipoInscripcionService;
	}

	@RequestMapping(value = "/rest/tiposinscripciones", method = RequestMethod.GET)
	public ResponseEntity<List<TipoInscripcion>> listAllTipoInscripcions() {
		List<TipoInscripcion> listTipoInscripcion = tipoInscripcionService.listTipoInscripcions();
		if (listTipoInscripcion.isEmpty()) {
			return new ResponseEntity<List<TipoInscripcion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TipoInscripcion>>(listTipoInscripcion, HttpStatus.OK);
	}

}
