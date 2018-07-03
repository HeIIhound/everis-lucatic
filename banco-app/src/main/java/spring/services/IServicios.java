package spring.services;

import java.math.BigDecimal;

import spring.model.Cuenta;
import spring.model.Movimiento;
import spring.model.Usuario;
import spring.model.Usuariologin;

public interface IServicios {
	
	
	public Boolean login(Usuariologin usuariologin);
	
	public Usuariologin getUsuariologin(Usuariologin usuariologin);
	
	public Usuario getUsuario(Usuariologin usuariologin);
	
	public Usuario getUsuarioByiD(int UsuarioId);
	
	public Movimiento getMovimientoByIdCuenta(Cuenta cuenta);
	
	public void IngresarExtraer(Cuenta cuenta, BigDecimal saldo);
}
