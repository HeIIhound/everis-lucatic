package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Usuariologin;

@Repository //Indica que es un DAO, tiene efecto sobre la transaccionalidad automática
public class UsuarioDAO {
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	@Autowired
	private SessionFactory sessionFactory;
	public UsuarioDAO() {
		
	}

	public UsuarioDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public void buscarUsuario(String User) {
		System.out.println("Ha llegado bien a la capa se datos");
		Usuariologin Usuario = new Usuariologin();

			String hql = "from Usuariologin where user ='"+ User + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			if (query.uniqueResult() != null) {
				Usuario = (Usuariologin)query.uniqueResult();
			}
			System.out.println(Usuario.getUser().toString());
			if (Usuario.getUser().equals(User)) {
				System.out.println("Usuario COINCIDE");
			}else {
				System.out.println("Usuario NO coincide");
			}
					
		
	}
}
