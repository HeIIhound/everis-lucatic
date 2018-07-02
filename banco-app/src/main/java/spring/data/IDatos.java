package spring.data;

import spring.model.Cuenta;
import spring.model.Movimiento;
import spring.model.Usuario;
import spring.model.Usuariologin;

public interface IDatos {
	

	public Boolean login(Usuariologin usuariologin);

	public Usuariologin getUsuariologin(Usuariologin usuariologin);

	public Usuario getUsuario(Usuariologin usuariologin);

	public Usuario getUsuarioByiD(int UsuarioId);

	public Movimiento getMovimientoByIdCuenta(Cuenta cuenta);
}
