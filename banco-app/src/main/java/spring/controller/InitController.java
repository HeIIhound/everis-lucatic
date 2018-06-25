package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Usuario;
import spring.model.Usuariologin;
import spring.services.IServicios;

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

	// pagina login
	@GetMapping("/")
	public String login() {
		return "login";
	}

	// pagina inicio
	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public ModelAndView inicio(@ModelAttribute Usuariologin usuariologin,@ModelAttribute Usuario us) {
		
		if (service.login(usuariologin) == true) {
			ModelAndView model = new ModelAndView("inicio");
			us = service.getUsuario(service.getUsuariologin(usuariologin));
			model.addObject("us",us);
			return model;
		} else {
			ModelAndView model = new ModelAndView("redirect:/");
			return model;
		}
	}
}
