/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.rest;

import java.util.List;

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

import mx.edu.uttab.spring.model.Empresa;
import mx.edu.uttab.spring.service.EmpresaService;

@RestController
public class EmpresaRestController {
	private EmpresaService empresaService;

	@Autowired(required = true)
	@Qualifier(value = "empresaService")
	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@RequestMapping(value = "/rest/empresas", method = RequestMethod.GET)
	public ResponseEntity<List<Empresa>> listAllEmpresas() {
		List<Empresa> listEmpresa = empresaService.listEmpresaByActivo(true);
		if (listEmpresa.isEmpty()) {
			return new ResponseEntity<List<Empresa>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Empresa>>(listEmpresa, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/empresa", method = RequestMethod.POST)
	public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa e, UriComponentsBuilder ucBuilder) {
		System.out.println("Entre a /rest/empresa");
		empresaService.addEmpresa(e);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/empresas/{id}").buildAndExpand(e.getId()).toUri());
		return new ResponseEntity<Empresa>(e, HttpStatus.CREATED);
	}

}