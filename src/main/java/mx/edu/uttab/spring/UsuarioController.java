/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.uttab.spring.model.Usuario;
import mx.edu.uttab.spring.service.UsuarioService;

@Controller
public class UsuarioController {
	private UsuarioService usuarioService;

	@Autowired(required = true)
	@Qualifier(value = "usuarioService")
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listUsuario", this.usuarioService.listUsuarios());
		return "usuarios/index";
	}

	@RequestMapping(value = "/usuarios/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarios/create";
	}

	@RequestMapping(value = "/usuarios/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("usuario") Usuario ti) {

		if (ti.getId() == 0) {
			// new person, add it
			this.usuarioService.addUsuario(ti);
		} else {
			// existing person, call update
			this.usuarioService.updateUsuario(ti);
		}

		return "redirect:/usuarios";

	}

	@RequestMapping("/usuarios/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("usuario", this.usuarioService.getUsuarioById(id));
		return "usuarios/edit";
	}

	@RequestMapping("/usuarios/{id}/destroy")
	public String destroy(@PathVariable("id") int id) {
		this.usuarioService.removeUsuario(id);
		;
		return "redirect:/usuarios";
	}

}
