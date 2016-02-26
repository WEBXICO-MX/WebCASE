/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import mx.edu.uttab.spring.model.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO {
	private static final Logger logger = LoggerFactory.getLogger(PersonaDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPersona(Persona p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Persona saved successfully, Persona Details=" + p);

	}

	@Override
	public void updatePersona(Persona p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Persona Updated successfully, Persona Details=" + p);

	}

	@Override
	public List<Persona> listPersona() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Persona> PersonaList = session.createQuery("from Persona").list();
		for (Persona p : PersonaList) {
			logger.info("Persona List::" + p);
		}
		return PersonaList;
	}

	@Override
	public Persona getPersonaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Persona p = (Persona) session.load(Persona.class, new Integer(id));
		logger.info("Persona loaded successfully, Persona details=" + p);
		return p;
	}

	@Override
	public void removePersona(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Persona p = (Persona) session.load(Persona.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Persona deleted successfully, Persona details=" + p);

	}

}
