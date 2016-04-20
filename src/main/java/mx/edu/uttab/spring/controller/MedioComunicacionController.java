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

import mx.edu.uttab.spring.model.MedioComunicacion;
import mx.edu.uttab.spring.service.MedioComunicacionService;
import mx.edu.uttab.spring.service.PersonaService;
import mx.edu.uttab.spring.service.TipoMedioComunicacionService;

@Controller
public class MedioComunicacionController {
	private MedioComunicacionService medioComunicacionService;
	private PersonaService personaService;
	private TipoMedioComunicacionService tipoMedioComunicacionService;

	@Autowired(required = true)
	@Qualifier(value = "medioComunicacionService")
	public void setMedioComunicacionService(MedioComunicacionService medioComunicacionService) {
		this.medioComunicacionService = medioComunicacionService;
	}

	@Autowired(required = true)
	@Qualifier(value = "personaService")
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@Autowired(required = true)
	@Qualifier(value = "tipoMedioComunicacionService")
	public void setTipoMedioComunicacionService(TipoMedioComunicacionService tipoMedioComunicacionService) {
		this.tipoMedioComunicacionService = tipoMedioComunicacionService;
	}

	@RequestMapping(value = "/medioscomunicacion", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("listMedioComunicacion", this.medioComunicacionService.listMedioComunicacion());
			return "mediosComunicacion/index";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/medioscomunicacion/new", method = RequestMethod.GET)
	public String create(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("medioComunicacion", new MedioComunicacion());
			model.addAttribute("listPersona", this.personaService.listPersona());
			model.addAttribute("listTipoMedioComunicacion",
					this.tipoMedioComunicacionService.listTipoMedioComunicacions());
			return "mediosComunicacion/create";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/medioscomunicacion/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("medioComunicacion") MedioComunicacion mc, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			if (mc.getId() == 0) {
				// new person, add it
				this.medioComunicacionService.addMedioComunicacion(mc);
			} else {
				// existing person, call update
				this.medioComunicacionService.updateMedioComunicacion(mc);
			}

			return "redirect:/medioscomunicacion";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/medioscomunicacion/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("medioComunicacion", this.medioComunicacionService.getMedioComunicacionById(id));
			model.addAttribute("listPersona", this.personaService.listPersona());
			model.addAttribute("listTipoMedioComunicacion",
					this.tipoMedioComunicacionService.listTipoMedioComunicacions());
			return "mediosComunicacion/edit";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/medioscomunicacion/{id}/destroy")
	public String destroy(@PathVariable("id") int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			this.medioComunicacionService.removeMedioComunicacion(id);
			return "redirect:/medioscomunicacion";
		} else {
			return "redirect:/";
		}

	}

}
