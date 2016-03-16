/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import mx.edu.uttab.spring.model.MedioComunicacion;
import mx.edu.uttab.spring.service.MedioComunicacionService;

@RestController
public class MedioComunicacionRestController {
	private MedioComunicacionService medioComunicacionService;

	@Autowired(required = true)
	@Qualifier(value = "medioComunicacionService")
	public void setMedioComunicacionService(MedioComunicacionService medioComunicacionService) {
		this.medioComunicacionService = medioComunicacionService;
	}

	@RequestMapping(value = "/rest/mediocomunicacion", method = RequestMethod.POST)
	public ResponseEntity<MedioComunicacion> createMedioComunicacion(@RequestBody MedioComunicacion mc,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Entre a /rest/medioComunicacion");
		medioComunicacionService.addMedioComunicacion(mc);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/medioComunicacions/{id}").buildAndExpand(mc.getId()).toUri());
		return new ResponseEntity<MedioComunicacion>(mc, HttpStatus.CREATED);
	}

}