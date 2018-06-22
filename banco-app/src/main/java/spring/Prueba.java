package spring;

//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;

import spring.data.Datos;
import spring.model.Usuariologin;
//import spring.data.Data;
//import spring.model.Usuariologin;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Datos data = new Datos();


		Usuariologin user = data.getUsuariologin("fpachecs");

		System.out.println(user.getUser());
		
	}

}
