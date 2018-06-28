package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@GetMapping({ "/", "/login" })
	public String login() {
		return "login";
	}

	// pagina inicio POST
	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public ModelAndView inicio(@ModelAttribute Usuariologin usuariologin, @ModelAttribute("Usuario") Usuario usuario) {

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

	// paginas de gestion de cuenta
	@RequestMapping(value = "/inicioVolverDesdeGestionCuenta", method = RequestMethod.GET)
	public ModelAndView inicioVolverGestionCuenta(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("idUsuario"));

		Usuario usuario = service.getUsuarioByiD(id);
		Set<Cuenta> c = usuario.getCuentas();
		ModelAndView model = new ModelAndView("inicio");

		model.addObject("usuario", usuario);
		model.addObject("c", c);
		return model;
	}

	@RequestMapping(value = { "/gestion", "gestionVolverDesdePerfil" })
	public ModelAndView gestionCuenta(HttpServletRequest request) {

		Usuario usuario = service.getUsuarioByiD(Integer.parseInt(request.getParameter("idUsuario")));

		Set<Cuenta> c = usuario.getCuentas();
		Cuenta cuen = new Cuenta();

		for (Cuenta cu : c) {

			if (cu.getId() == Integer.parseInt(request.getParameter("idCuenta"))) {

				cuen = cu;
			}
		}

		Integer.parseInt(request.getParameter("idUsuario"));

		ModelAndView model = new ModelAndView("gestionCuenta");
		model.addObject("usuario", usuario);
		model.addObject("cuenta", cuen);
		return model;
	}

	//pagina de perfil
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public ModelAndView perfil(HttpServletRequest request) {

		Usuario usuario = service.getUsuarioByiD(Integer.parseInt(request.getParameter("idUsuario")));
		Set<Cuenta> c = usuario.getCuentas();

		Cuenta cuen = new Cuenta();

		for (Cuenta cu : c) {

			if (cu.getId() == Integer.parseInt(request.getParameter("idCuenta"))) {

				cuen = cu;
			}
		}

		Set<Usuariologin> usuariologin = usuario.getUsuariologins();
		ModelAndView model = new ModelAndView("perfil");
		model.addObject("usuario", usuario);
		model.addObject("cuenta", cuen);
		model.addObject("c", c);
		model.addObject("usuariologin", usuariologin);
		return model;
	}
}
