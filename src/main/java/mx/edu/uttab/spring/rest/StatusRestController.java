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
import mx.edu.uttab.spring.model.Status;
import mx.edu.uttab.spring.service.StatusService;

@RestController
public class StatusRestController {

	private StatusService statusService;

	@Autowired(required = true)
	@Qualifier(value = "statusService")
	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

	@RequestMapping(value = "/rest/status", method = RequestMethod.GET)
	public ResponseEntity<List<Status>> listAllStatuss() {
		List<Status> listStatus = statusService.listStatusByActivo(true);
		if (listStatus.isEmpty()) {
			return new ResponseEntity<List<Status>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Status>>(listStatus, HttpStatus.OK);
	}

}