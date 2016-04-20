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

import mx.edu.uttab.spring.model.Status;
import mx.edu.uttab.spring.service.StatusService;

@Controller
public class StatusController {
	private StatusService statusService;

	@Autowired(required = true)
	@Qualifier(value = "statusService")
	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("listStatus", this.statusService.listStatuss());
			return "status/index";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/status/new", method = RequestMethod.GET)
	public String create(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("status", new Status());
			return "status/create";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/status/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("status") Status s, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			if (s.getId() == 0) {
				// new person, add it
				this.statusService.addStatus(s);
				;
			} else {
				// existing person, call update
				this.statusService.updateStatus(s);
			}

			return "redirect:/status";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/status/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("status", this.statusService.getStatusById(id));
			return "status/edit";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/status/{id}/destroy")
	public String destroy(@PathVariable("id") int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			this.statusService.removeStatus(id);
			return "redirect:/status";
		} else {
			return "redirect:/";
		}

	}

}
