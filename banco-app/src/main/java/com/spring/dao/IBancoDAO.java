package com.spring.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import com.spring.model.Cuenta;
import com.spring.model.Usuario;
import com.spring.model.Usuariologin;

public interface IBancoDAO {

	boolean comprobarUsuario(Usuariologin User);

	Usuariologin buscarUsuario(Usuariologin User);

	Usuario buscarCliente(Usuariologin User);

	Usuario buscarClienteSeleccionado(int idUser);

	List<Cuenta> buscarCuenta(Usuariologin User);

	Cuenta buscarCuentaSeleccionada(int idCuenta);

	boolean comprobarMovimientos(Cuenta cuentaSelec);

	Cuenta operativa(int idCuenta, String cantidad, String operativa) throws ParseException;

	void registrarAcceso(String idUser);

	void registrarMovimiento(Cuenta CuentaSelec, BigDecimal cantidad, String operacion);

}
