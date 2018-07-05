package com.spring.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.IBancoDAO;
import com.spring.model.Cuenta;
import com.spring.model.Usuario;
import com.spring.model.Usuariologin;

@Service
@Transactional
public class BancoServices implements IBancoServices {

	@Autowired
	private IBancoDAO BancoDAO;

	@Override
	public boolean comprobarUsuario(Usuariologin User) {
		return BancoDAO.comprobarUsuario(User);
	}

	@Override
	public Usuariologin buscarUsuario(Usuariologin User) {
		return BancoDAO.buscarUsuario(User);
	}

	@Override
	public Usuario buscarCliente(Usuariologin User) {
		return BancoDAO.buscarCliente(User);
	}

	@Override
	public Usuario buscarClienteSeleccionado(int idUser) {
		return BancoDAO.buscarClienteSeleccionado(idUser);
	}

	@Override
	public List<Cuenta> buscarCuenta(Usuariologin User) {
		return BancoDAO.buscarCuenta(User);
	}

	@Override
	public Cuenta buscarCuentaSeleccionada(int idCuenta) {
		return BancoDAO.buscarCuentaSeleccionada(idCuenta);
	}

	@Override
	public boolean comprobarMovimientos(Cuenta cuentaSelec) {
		return BancoDAO.comprobarMovimientos(cuentaSelec);
	}

	@Override
	public Cuenta operativa(int idCuenta, String cantidad, String operativa) throws ParseException {
		return BancoDAO.operativa(idCuenta, cantidad, operativa);
	}

	@Override
	public void registrarAcceso(String idUser) {
		BancoDAO.registrarAcceso(idUser);

	}

	@Override
	public void registrarMovimiento(Cuenta CuentaSelec, BigDecimal cantidad, String operacion) {
		BancoDAO.registrarMovimiento(CuentaSelec, cantidad, operacion);

	}

}
