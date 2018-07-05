package com.spring.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.*;

@Repository // Indica que es un DAO, tiene efecto sobre la transaccionalidad automática
public class BancoDAO implements IBancoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BancoDAO() {

	}

	public BancoDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean comprobarUsuario(Usuariologin User) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Usuariologin where user ='" + User.getUser() + "'");
		Usuariologin ListaUsuarios = (Usuariologin) query.uniqueResult();
		if (ListaUsuarios == null) {
			JOptionPane.showMessageDialog(null, "El usuario no tiene permisos de acceso", "ACCESO DENEGADO",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (ListaUsuarios.getPass().equals(User.getPass())) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "La contraseña no es correcta", "ACCESO DENEGADO",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

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
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Cuenta where idUser ='" + User.getId() + "'");
		@SuppressWarnings("unchecked") // Ignora los posibles problemas del "cast" de la lista de objetos
		List<Cuenta> ListaCuentas = (List<Cuenta>) query.list();
		return ListaCuentas;
	}

	@Transactional
	public Cuenta buscarCuentaSeleccionada(int idCuenta) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Cuenta where id ='" + idCuenta + "'");
		Cuenta CuentaSelec = (Cuenta) query.uniqueResult();
		return CuentaSelec;
	}

	@Transactional
	public boolean comprobarMovimientos(Cuenta cuentaSelec) {
		boolean movimientos = false;
		if (cuentaSelec.getMovimientos().size() != 0) {
			movimientos = true;
		}
		return movimientos;
	}

	@Transactional
	public Cuenta operativa(int idCuenta, String cantidad, String operativa) throws ParseException {
		Query query = sessionFactory.getCurrentSession().createQuery("from Cuenta where id ='" + idCuenta + "'");
		Cuenta CuentaSelec = (Cuenta) query.uniqueResult();
		BigDecimal saldo = CuentaSelec.getSaldo();
		BigDecimal cantidadBD = new BigDecimal(cantidad);
		BigDecimal res = saldo.add(cantidadBD); // Realiza la suma. Cuendo sea una extraccion, suma un numero negativo
		CuentaSelec.setSaldo(res);
		sessionFactory.getCurrentSession().saveOrUpdate(CuentaSelec);
		JOptionPane.showMessageDialog(null,
				"La operación " + operativa + " " + cantidad + "€ se ha realizado correctamente", "OPERACIÓN REALIZADA",
				JOptionPane.INFORMATION_MESSAGE);
		registrarMovimiento(CuentaSelec, cantidadBD, operativa);
		return CuentaSelec;
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

	@Transactional
	public void registrarAcceso(String idUser) {
		Usuariologin UserSelec = (Usuariologin) sessionFactory.getCurrentSession()
				.createQuery("from Usuariologin where idUser ='" + idUser + "'").uniqueResult();
		UserSelec.setUltimoAcceso(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(UserSelec);
	}

}
