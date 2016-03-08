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

import mx.edu.uttab.spring.model.RegistroCapacitacion;

@Repository
public class RegistroCapacitacionDAOImpl implements RegistroCapacitacionDAO {
	private Logger logger = LoggerFactory.getLogger(RegistroCapacitacionDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addRegistroCapacitacion(RegistroCapacitacion rc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(rc);
		logger.info("RegistroCapacitacion saved successfully, RegistroCapacitacion Details=" + rc);

	}

	@Override
	public void updateRegistroCapacitacion(RegistroCapacitacion rc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(rc);
		logger.info("RegistroCapacitacion Updated successfully, RegistroCapacitacion Details=" + rc);

	}

	@Override
	public List<RegistroCapacitacion> listRegistroCapacitacion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RegistroCapacitacion> RegistroCapacitacionList = session.createQuery("from RegistroCapacitacion").list();
		for (RegistroCapacitacion rc : RegistroCapacitacionList) {
			logger.info("RegistroCapacitacion List::" + rc);
		}
		return RegistroCapacitacionList;
	}
	
	@Override
	public List<RegistroCapacitacion> listRegistroCapacitacionByStatus(int status) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from RegistroCapacitacion where status_id.id = :status_id";
		List<RegistroCapacitacion> RegistroCapacitacionList = session.createQuery(sql).setInteger("status_id", status).list();
		for (RegistroCapacitacion rc : RegistroCapacitacionList) {
			logger.info("RegistroCapacitacion List::" + rc);
		}
		return RegistroCapacitacionList;
	}

	@Override
	public RegistroCapacitacion getRegistroCapacitacionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		RegistroCapacitacion rc = (RegistroCapacitacion) session.load(RegistroCapacitacion.class, new Integer(id));
		logger.info("RegistroCapacitacion loaded successfully, RegistroCapacitacion details=" + rc);
		return rc;
	}

	@Override
	public void removeRegistroCapacitacion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		RegistroCapacitacion rc = (RegistroCapacitacion) session.load(RegistroCapacitacion.class, new Integer(id));
		if (null != rc) {
			session.delete(rc);
		}
		logger.info("RegistroCapacitacion deleted successfully, RegistroCapacitacion details=" + rc);

	}

	

}
