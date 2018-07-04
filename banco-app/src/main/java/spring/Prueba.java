package spring;

import org.springframework.beans.factory.annotation.Autowired;

import spring.model.Usuario;
import spring.services.IServicios;

public class Prueba {

	@Autowired
	private static IServicios service;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Usuario usuario = service.getUsuarioByiD(2);
		System.out.println(usuario.getNombre());

		
		//ventana de error en login
		//ordenar lista movimiento
		//decimal en ingresar y extraer
		//
		
		
	}//fin main

}
