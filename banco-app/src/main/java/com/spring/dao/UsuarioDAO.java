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
		for (int i = 0; i < ListaUsuarios.size();) {
			return true;
		}
		return false;
	}

	@Transactional
	public Usuariologin buscarUsuario(Usuariologin User) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Usuariologin where user ='" + User.getUser() + "' AND pass='" + User.getPass() + "'");
		Usuariologin Usuariolog = (Usuariologin) query.uniqueResult();
		return Usuariolog;
	}

	@Transactional
	public Usuario buscarCliente(Usuariologin User) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Usuario where id ='" + User.getId() + "'");
		Usuario Cliente = (Usuario) query.uniqueResult();
		return Cliente;
	}
	
	@Transactional
	public Usuario buscarClienteSeleccionado(int idUser) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Usuario where id ='" + idUser + "'");
		Usuario ClienteSelec = (Usuario) query.uniqueResult();
		return ClienteSelec;
	}
	
	@Transactional
	public List<Cuenta> buscarCuenta(Usuariologin User) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Cuenta where idUser ='" + User.getId() + "'");
		List<Cuenta> ListaCuentas = (List<Cuenta>) query.list();
		return ListaCuentas;
	}
	
	@Transactional
	public Cuenta buscarCuentaSeleccionada(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Cuenta where id ='" + id + "'");
		Cuenta CuentaSelec = (Cuenta) query.uniqueResult();
		return CuentaSelec;
	}
}
