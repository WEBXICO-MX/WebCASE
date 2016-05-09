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
import mx.edu.uttab.spring.model.TipoMedioComunicacion;
import mx.edu.uttab.spring.service.TipoMedioComunicacionService;

@RestController
public class TipoMedioComunicacionRestController {

	private TipoMedioComunicacionService tipoMedioComunicacionService;

	@Autowired(required = true)
	@Qualifier(value = "tipoMedioComunicacionService")
	public void setTipoMedioComunicacionService(TipoMedioComunicacionService tipoMedioComunicacionService) {
		this.tipoMedioComunicacionService = tipoMedioComunicacionService;
	}

	@RequestMapping(value = "/rest/tiposmedioscomunicacion", method = RequestMethod.GET)
	public ResponseEntity<List<TipoMedioComunicacion>> listAllTipoMedioComunicacions() {
		List<TipoMedioComunicacion> listTipoMedioComunicacion = tipoMedioComunicacionService.listTipoMedioComunicacionByActivo(true);
		if (listTipoMedioComunicacion.isEmpty()) {
			return new ResponseEntity<List<TipoMedioComunicacion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TipoMedioComunicacion>>(listTipoMedioComunicacion, HttpStatus.OK);
	}

}
