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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String form_login(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			return "redirect:/home";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("usuario") Usuario u, HttpServletRequest request) {
		Usuario usr = this.usuarioService.getUsuarioByLoginPassword(u.getLogin(), u.getPassword());
		if (usr != null) {
			HttpSession session = request.getSession();
			session.setAttribute("cve_usuario", usr.getId());
			session.setAttribute("nombre", usr.getNombre());

			return "redirect:/home";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("listUsuario", this.usuarioService.listUsuarios());
			return "usuarios/index";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/usuarios/new", method = RequestMethod.GET)
	public String create(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("usuario", new Usuario());
			return "usuarios/create";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/usuarios/create", method = RequestMethod.POST)
	public String store(@ModelAttribute("usuario") Usuario u, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			if (u.getId() == 0) {
				// new person, add it
				this.usuarioService.addUsuario(u);
			} else {
				// existing person, call update
				this.usuarioService.updateUsuario(u);
			}

			return "redirect:/usuarios";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping("/usuarios/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			model.addAttribute("usuario", this.usuarioService.getUsuarioById(id));
			return "usuarios/edit";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/usuarios/{id}/destroy")
	public String destroy(@PathVariable("id") int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("nombre") != null && session.getAttribute("cve_usuario") != null) {
			this.usuarioService.removeUsuario(id);
			return "redirect:/usuarios";
		} else {
			return "redirect:/";
		}

	}

}
