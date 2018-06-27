package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Cuenta;
import spring.model.Usuario;
import spring.model.Usuariologin;
import spring.services.IServicios;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

@Controller
public class InitController {

	@Autowired
	private IServicios service;

	// UsuarioLogin
	@ModelAttribute("Usuariologin")
	public Usuariologin usuarioLoginObject() {

		return new Usuariologin();
	}

	@ModelAttribute("Usuario")
	public Usuario usuarioObject() {

		return new Usuario();
	}

	// UsuarioLogin
	@ModelAttribute("Cuenta")
	public Cuenta cuentaObject() {

		return new Cuenta();
	}

	// pagina login
	@GetMapping("/")
	public String login() {
		return "login";
	}

	// pagina inicio POST
	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public ModelAndView inicio(@ModelAttribute Usuariologin usuariologin,@ModelAttribute("Usuario") Usuario usuario) {
		
		if (service.login(usuariologin) == true) {
			ModelAndView model = new ModelAndView("inicio");
			usuario = service.getUsuario(service.getUsuariologin(usuariologin));
			model.addObject("usuario", usuario);
			Set<Cuenta> c = usuario.getCuentas();
			model.addObject("c", c);
			return model;
		} else {
			ModelAndView model = new ModelAndView("redirect:/");
			return model;
		}
	}

	// pagina inicio GET
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public ModelAndView inicio() {

		ModelAndView model = new ModelAndView("inicio");
		return model;
	}

	// pagina de gestion de cuenta
	@RequestMapping(value = "/gestion", method = RequestMethod.GET)
	public ModelAndView gestionCuenta(HttpServletRequest request, @ModelAttribute Usuario Usuario) {
		System.out.println(Usuario.getNombre());
		int idcuenta = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView("gestionCuenta");

		return model;
	}
}
