package spring.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.Cuenta;
import spring.model.Movimiento;
import spring.model.Usuario;
import spring.model.Usuariologin;

@Repository
public class Datos implements IDatos {

	@Autowired
	private SessionFactory sessionFactory;

	public Datos() {

	}

	public Datos(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Boolean login(Usuariologin usuariologin) {

		Query query = sessionFactory.getCurrentSession().createQuery("from Usuariologin");
		@SuppressWarnings("unchecked")
		List<Usuariologin> list = query.list();

		Boolean login = false;

		for (Usuariologin u : list) {

			if (usuariologin.getUser().equals(u.getUser()) && usuariologin.getPass().equals(u.getPass())) {
				login = true;
			}
		}
		return login;
	}

	@Override
	@Transactional
	public Usuariologin getUsuariologin(Usuariologin usuariologin) {

		Usuariologin usuariolog = new Usuariologin();

		Query query = sessionFactory.getCurrentSession().createQuery("from Usuariologin");
		@SuppressWarnings("unchecked")
		List<Usuariologin> list = query.list();

		for (Usuariologin u : list) {

			if (usuariologin.getUser().equals(u.getUser()) && usuariologin.getPass().equals(u.getPass())) {
				usuariolog = u;
			}
		}
		return usuariolog;
	}

	@Override
	@Transactional
	public Usuario getUsuario(Usuariologin usuariologin) {

		Usuario usuario = new Usuario();

		Query query = sessionFactory.getCurrentSession().createQuery("from Usuario");
		@SuppressWarnings("unchecked")
		List<Usuario> list = query.list();

		for (Usuario u : list) {

			if (u.getId().equals(usuariologin.getId())) {
				usuario = u;
			}
		}
		return usuario;
	}
	
	//Busca y devuelve un usuario por su id
	@Override
	@Transactional
	public Usuario getUsuarioByiD(int UsuarioId) {

		Usuario usu = new Usuario();

		Query query = sessionFactory.getCurrentSession().createQuery("from Usuario");
		@SuppressWarnings("unchecked")
		List<Usuario> list = query.list();

		for (Usuario u : list) {

			if (u.getId() == UsuarioId) {
				usu = u;
			}
		}
		return usu;
	}
	
	//Busca y devuelve los movimientos de una cuenta por su id
	@Override
	@Transactional
	public Movimiento getMovimientoByIdCuenta(Cuenta cuenta) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Movimiento");
		@SuppressWarnings("unchecked")
		List<Movimiento> list = query.list();

		Movimiento movimiento = new Movimiento();
		for (Movimiento u : list) {

			if (u.getCuenta().equals(cuenta)) {
				movimiento = u;
			}
		}
		
		
		return movimiento;
	}
	
	
	@Override
	@Transactional
	public void IngresarExtraer(Cuenta cuenta,BigDecimal saldo) {
		String operacion = null;
		if(saldo.signum() == -1) {
			cuenta.setSaldo(cuenta.getSaldo().add(saldo));
			sessionFactory.getCurrentSession().saveOrUpdate(cuenta);
			operacion = "extraer";
			movimiento(cuenta,saldo,operacion);
		}else if (saldo.signum() == 1){
			cuenta.setSaldo(cuenta.getSaldo().add(saldo));
			sessionFactory.getCurrentSession().update(cuenta);
			operacion = "ingresar";
			movimiento(cuenta,saldo,operacion);
		}
		
	}
	
	
	public void movimiento(Cuenta cuenta,BigDecimal saldo,String operacion) {
		Movimiento movimiento = new Movimiento();
		
		Date date = new Date();
		movimiento.setCuenta(cuenta);
		movimiento.setFechaOperacion(date);
		movimiento.setCantidad(saldo);
		movimiento.setTipoOperacion(operacion);
		
		sessionFactory.getCurrentSession().save(movimiento);
	}
	
	
	
	
}
