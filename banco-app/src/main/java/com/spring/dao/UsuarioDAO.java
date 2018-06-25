package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.*;

@Repository // Indica que es un DAO, tiene efecto sobre la transaccionalidad automática
public class UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UsuarioDAO() {

	}

	public UsuarioDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Boolean comprobarUsuario(Usuariologin User) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Usuariologin where user ='" + User.getUser() + "' AND pass='" + User.getPass() + "'");
		@SuppressWarnings("unchecked")
		List<Usuariologin> ListaUsuarios = query.list();

		for (Usuariologin u : ListaUsuarios) {
			return true;
		}
		return false;
	}

	@Transactional
	public Usuariologin buscarUsuario(Usuariologin User) {
		System.out.println("-----------Lega al buscarUsuario");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Usuariologin where user ='" + User.getUser() + "' AND pass='" + User.getPass() + "'");
		Usuariologin Usuariolog = (Usuariologin) query.uniqueResult();
		System.out.println(Usuariolog.getUser());
		System.out.println(Usuariolog.getId());
		System.out.println("-----------deberia haber mostrado usuario encontrado");
		return Usuariolog;

	}

	@Transactional
	public Usuario buscarCliente(Usuariologin User) {
		System.out.println("-----------Lega al buscarCliente");
		System.out.println(User.getId());
		Query query = sessionFactory.getCurrentSession().createQuery("from Usuario where id ='" + User.getId() + "'");
		if (query.uniqueResult() != null) {
			System.out.println("query con resul");
		} else {
			System.out.println("query NO resul");
		}
		Usuario Cliente = (Usuario) query.uniqueResult();
		System.out.println(Cliente.getNombre());
		System.out.println(Cliente.getApellido());
		System.out.println("-----------deberia haber mostrado Cliente encontrado");
		return Cliente;
	}
}
