package spring.services;

import spring.model.Usuario;
import spring.model.Usuariologin;

public interface IServicios {
	
	
	public Boolean login(Usuariologin usuariologin);
	
	public Usuariologin getUsuariologin(Usuariologin usuariologin);
	
	public Usuario getUsuario(Usuariologin usuariologin);
}
