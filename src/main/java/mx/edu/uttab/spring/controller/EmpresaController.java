/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.uttab.spring.model.Empresa;
import mx.edu.uttab.spring.service.EmpresaService;
import mx.edu.uttab.spring.service.SectorProductivoService;

@Controller
public class EmpresaController {
	private EmpresaService empresaService;
	private SectorProductivoService sectorProductivoService;

	@Autowired(required = true)
	@Qualifier(value = "empresaService")
	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@Autowired(required = true)
	@Qualifier(value = "sectorProductivoService")
	public void setSectorProductivoService(SectorProductivoService sectorProductivoService) {
		this.sectorProductivoService = sectorProductivoService;
	}

	@RequestMapping(value = "/empresas", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("listEmpresa", this.empresaService.listEmpresa());
			return "empresas/index";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/empresas/new", method = RequestMethod.GET)
	public String create(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("empresa", new Empresa());
			model.addAttribute("listSectorProductivo", this.sectorProductivoService.listSectorProductivos());
			return "empresas/create";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/empresas/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("empresa") Empresa e, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			if (e.getId() == 0) {
				// new person, add it
				this.empresaService.addEmpresa(e);
				;
			} else {
				// existing person, call update
				this.empresaService.updateEmpresa(e);
			}

			return "redirect:/empresas";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/empresas/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("empresa", this.empresaService.getEmpresaById(id));
			model.addAttribute("listSectorProductivo", this.sectorProductivoService.listSectorProductivos());
			return "empresas/edit";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/empresas/{id}/destroy")
	public String destroy(@PathVariable("id") int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			this.empresaService.removeEmpresa(id);
			return "redirect:/empresas";
		} else {
			return "redirect:/";
		}

	}

}
