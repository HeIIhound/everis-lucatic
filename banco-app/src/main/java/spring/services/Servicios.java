package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.data.IDatos;
import spring.model.Usuariologin;

@Service
@Transactional
public class Servicios implements IServicios {

	 @Autowired
	 private IDatos idatos;
	 
	@Override
	public Usuariologin getUsuariologin(String user) {
		
		return idatos.getUsuariologin(user);
	}
}
