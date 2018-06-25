package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.data.IDatos;
import spring.model.Usuario;
import spring.model.Usuariologin;

@Service
@Transactional
public class Servicios implements IServicios {

	 @Autowired
	 private IDatos idatos;
	 
	
	@Override
	public Boolean login(Usuariologin usuariologin) {
		
		return idatos.login(usuariologin);
	}

	@Override
	public Usuariologin getUsuariologin(Usuariologin usuariologin) {
		
		return idatos.getUsuariologin(usuariologin);
	}
	
	@Override
	public Usuario getUsuario(Usuariologin usuariologin) {
		
		return idatos.getUsuario(usuariologin);
	}
}
