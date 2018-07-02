package com.spring.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
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
	
	@Transactional
	public boolean comprobarMovimientos(Cuenta cuentaSelec) {
		boolean movimientos = false;
		if(cuentaSelec.getMovimientos().size()!=0) {
			movimientos= true;
		}
		System.out.println(movimientos);
		return movimientos;
	}
	
	@Transactional
	public Cuenta operativa(int idCuenta, String cantidad, String operativa ) throws ParseException {
		Query query = sessionFactory.getCurrentSession().createQuery("from Cuenta where id ='" + idCuenta + "'");
		Cuenta CuentaSelec = (Cuenta) query.uniqueResult();
		BigDecimal saldo = CuentaSelec.getSaldo();
		BigDecimal cantidadBD =new BigDecimal(cantidad);
		BigDecimal res = null;
		if(operativa.equals("extraer")) {
			res = saldo.subtract(cantidadBD);//realiza la resta 
		}else if (operativa.equals("ingresar")) {
			res = saldo.add(cantidadBD);//realiza la suma 
		} 
		CuentaSelec.setSaldo(res);
		sessionFactory.getCurrentSession().saveOrUpdate(CuentaSelec);
		registrarMovimiento(CuentaSelec, cantidadBD, operativa);
		return CuentaSelec;
	}
	
	@Transactional
	public void registrarAcceso(String idUser) {
		Usuariologin UserSelec = (Usuariologin) sessionFactory.getCurrentSession().createQuery("from Usuariologin where idUser ='" + idUser + "'").uniqueResult();
		UserSelec.setUltimoAcceso(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(UserSelec);
	}
	
	@Transactional
	public void registrarMovimiento(Cuenta CuentaSelec, BigDecimal cantidad, String operacion) {
		Movimiento registroMovimiento = new Movimiento();
		registroMovimiento.setCuenta(CuentaSelec);
		Date now = new Date();
		registroMovimiento.setFechaOperacion(now);
		registroMovimiento.setCantidad(cantidad);
		registroMovimiento.setTipoOperacion(operacion);
		sessionFactory.getCurrentSession().save(registroMovimiento);
	}
	
	
	
}
