/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.controller;

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
	public String index(Model model) {
		model.addAttribute("listStatus", this.statusService.listStatuss());
		return "status/index";
	}

	@RequestMapping(value = "/status/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("status", new Status());
		return "status/create";
	}

	@RequestMapping(value = "/status/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("status") Status s) {

		if (s.getId() == 0) {
			// new person, add it
			this.statusService.addStatus(s);
			;
		} else {
			// existing person, call update
			this.statusService.updateStatus(s);
		}

		return "redirect:/status";

	}

	@RequestMapping("/status/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("status", this.statusService.getStatusById(id));
		return "status/edit";
	}

	@RequestMapping("/status/{id}/destroy")
	public String destroy(@PathVariable("id") int id) {
		this.statusService.removeStatus(id);
		;
		return "redirect:/status";
	}

}
