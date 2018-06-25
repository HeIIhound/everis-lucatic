package spring.data;

import spring.model.Usuario;
import spring.model.Usuariologin;

public interface IDatos {
	

	public Boolean login(Usuariologin usuariologin);

	public Usuariologin getUsuariologin(Usuariologin usuariologin);

	public Usuario getUsuario(Usuariologin usuariologin);
}
