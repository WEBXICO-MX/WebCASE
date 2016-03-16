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
import mx.edu.uttab.spring.model.SectorProductivo;
import mx.edu.uttab.spring.service.SectorProductivoService;

@RestController
public class SectorProductivoRestController {

	private SectorProductivoService sectorProductivoService;

	@Autowired(required = true)
	@Qualifier(value = "sectorProductivoService")
	public void setSectorProductivoService(SectorProductivoService sectorProductivoService) {
		this.sectorProductivoService = sectorProductivoService;
	}

	@RequestMapping(value = "/rest/sectoresproductivos", method = RequestMethod.GET)
	public ResponseEntity<List<SectorProductivo>> listAllSectorProductivos() {
		List<SectorProductivo> listSectorProductivo = sectorProductivoService.listSectorProductivos();
		if (listSectorProductivo.isEmpty()) {
			return new ResponseEntity<List<SectorProductivo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SectorProductivo>>(listSectorProductivo, HttpStatus.OK);
	}

}