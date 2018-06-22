package com.spring.pruebas;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.model.Usuariologin;

public class Pruebas{
	
	@Autowired
	private static SessionFactory sessionFactory;
	
	
		public static void main(String[] args) {
			Usuariologin Usuariologin = new Usuariologin();
			String hql = "select * from usuariologin where user = declaroba ";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			if (query.list() != null) {
				Usuariologin = (Usuariologin) query.list();
			}
			
			System.out.println("Usuario encontrado" + Usuariologin);

		

	}



}
