package com.spring.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	// Especificacion para el @ModelAttribute
	@ModelAttribute("Usuariologin")
	public Usuariologin modelAttribute() {
		return new Usuariologin();
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public ModelAndView inicio(@ModelAttribute Usuariologin user) throws Exception {
		if (IUsuarioDAO.comprobarUsuario(user) == true) {
			Usuario cliente = IUsuarioDAO.buscarCliente(IUsuarioDAO.buscarUsuario(user));
			ModelAndView model = new ModelAndView("inicio");
			model.addObject("cliente", cliente);
			return model;
		} else {
			ModelAndView model = new ModelAndView("redirect:/");
			return model;
		}
	}

	@RequestMapping(value = "/cuenta", method = RequestMethod.GET)
	public ModelAndView cuentas(HttpServletRequest request) throws Exception {
		Cuenta cuentaSelec = IUsuarioDAO.buscarCuentaSeleccionada(Integer.parseInt(request.getParameter("idCuenta")));
		ModelAndView model = new ModelAndView("cuenta");
		model.addObject("cuentaSelec", cuentaSelec);
		return model;
	}

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public ModelAndView perfil(HttpServletRequest request) throws Exception {
		int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
		Usuario clienteSelec = IUsuarioDAO.buscarClienteSeleccionado(Integer.parseInt(request.getParameter("idUser")));
		ModelAndView model = new ModelAndView("perfil");
		model.addObject("idCuenta", idCuenta);
		model.addObject("clienteSelec", clienteSelec);
		return model;
	}

	@RequestMapping(value = "/movimientos", method = RequestMethod.GET)
	public ModelAndView movimientos(HttpServletRequest request) throws Exception {
		Cuenta cuentaSelec = IUsuarioDAO.buscarCuentaSeleccionada(Integer.parseInt(request.getParameter("idCuenta")));
		boolean valor = IUsuarioDAO.comprobarMovimientos(cuentaSelec);
		
		//Nos convierte el set en list
		List<Movimiento> listamov = new ArrayList<Movimiento>(cuentaSelec.getMovimientos());
		
		//Nos ordena la lista de movimientos
		Collections.sort(listamov, new Comparator<Movimiento>(){
			@Override
			public int compare(Movimiento o1, Movimiento o2) {
				return o1.getId().compareTo(o2.getId());
			}						
		});
		
		ModelAndView model = new ModelAndView("movimientos");
		model.addObject("cuentaSelec", cuentaSelec);
		model.addObject("valor", valor);
		model.addObject("listamov", listamov);
		return model;
	}

	@RequestMapping(value = "/ingresar", method = RequestMethod.GET)
	public ModelAndView ingresar(HttpServletRequest request) throws Exception {
		Cuenta cuentaSelec = IUsuarioDAO.buscarCuentaSeleccionada(Integer.parseInt(request.getParameter("idCuenta")));
		ModelAndView model = new ModelAndView("ingresar");
		model.addObject("cuentaSelec", cuentaSelec);
		return model;
	}

	@RequestMapping(value = "/extraer", method = RequestMethod.GET)
	public ModelAndView extraer(HttpServletRequest request) throws Exception {
		Cuenta cuentaSelec = IUsuarioDAO.buscarCuentaSeleccionada(Integer.parseInt(request.getParameter("idCuenta")));
		ModelAndView model = new ModelAndView("extraer");
		model.addObject("cuentaSelec", cuentaSelec);
		return model;
	}

	@RequestMapping(value = "/volver", method = RequestMethod.GET)
	public ModelAndView volver(HttpServletRequest request) throws Exception {
		Usuario cliente = IUsuarioDAO.buscarClienteSeleccionado(Integer.parseInt(request.getParameter("idUser")));
		ModelAndView model = new ModelAndView("inicio");
		model.addObject("cliente", cliente);
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) throws Exception {
		IUsuarioDAO.registrarAcceso(request.getParameter("idUser"));
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value = "/operativa", method = RequestMethod.POST)
	public ModelAndView operativa(HttpServletRequest request) throws Exception {
		String cantidad = request.getParameter("cantidad");
		int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
		String operativa = request.getParameter("operativa");
		Cuenta cuentaSelec = IUsuarioDAO.operativa(idCuenta, cantidad, operativa);
		ModelAndView model = new ModelAndView(operativa);
		model.addObject("cuentaSelec", cuentaSelec);
		return model;
		
	}
	
}
