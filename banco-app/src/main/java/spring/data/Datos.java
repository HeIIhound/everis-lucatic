package spring.data;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		System.out.println("1");
		String hql = "from usuariologin where user= :user";
		System.out.println("2");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("3");
		query.setParameter("user", user);
		System.out.println("4");
		Usuariologin usuario = (Usuariologin) query.uniqueResult();
		System.out.println("5");
		return usuario;
	}

}
