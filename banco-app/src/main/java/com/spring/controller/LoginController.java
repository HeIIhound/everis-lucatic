package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.*;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDAO UsuarioDAO;

	@RequestMapping("/")
	public String handleRequest() throws Exception {
		return "login";
	}
	
	public int operacion(int numero){
		int resultado = numero *2;
		return resultado;
	}
	
//	@RequestMapping("/login")
//	public void buscarUsuario() throws Exception {
//		UsuarioDAO.buscarUsuario();
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView inicio() throws Exception {
		UsuarioDAO.buscarUsuario("declaroba");
		ModelAndView model = new ModelAndView("cuentas");
		return model;	
	}
	

}
