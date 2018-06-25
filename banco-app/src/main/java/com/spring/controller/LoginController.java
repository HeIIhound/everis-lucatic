package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.*;
import com.spring.model.*;

@Controller
public class LoginController {

	@Autowired
	private UsuarioDAO IUsuarioDAO;

	@RequestMapping("/")
	public String handleRequest() throws Exception {
		return "login";
	}

	public int operacion(int numero) {
		int resultado = numero * 2;
		return resultado;
	}

	@ModelAttribute("Usuariologin")
	public Usuariologin modelAttribute() {
		return new Usuariologin();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView inicio(@ModelAttribute Usuariologin user) throws Exception {

		if (IUsuarioDAO.comprobarUsuario(user) == true) {
			Usuario Cliente = IUsuarioDAO.buscarCliente(IUsuarioDAO.buscarUsuario(user));
			ModelAndView model = new ModelAndView("cuentas");
			model.addObject("Cliente", Cliente);
			return model;
		} else {
			ModelAndView model = new ModelAndView("redirect:/");
			return model;
		}
	}

}
