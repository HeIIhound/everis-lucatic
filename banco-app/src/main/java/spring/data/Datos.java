package spring.data;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public Usuariologin getUsuariologin(String user) {
		String hql = "from Usuariologin where user= :user";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("user", user);
		Usuariologin usuario = (Usuariologin) query.uniqueResult();
		return usuario;
	}

}
