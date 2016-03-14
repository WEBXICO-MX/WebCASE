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

import mx.edu.uttab.spring.model.CalendarioCapacitacion;

@Repository
public class CalendarioCapacitacionDAOImpl implements CalendarioCapacitacionDAO {
	private Logger logger = LoggerFactory.getLogger(CalendarioCapacitacionDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCalendarioCapacitacion(CalendarioCapacitacion cc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cc);
		logger.info("CalendarioCapacitacion guardada, CalendarioCapacitacion Detalle" + cc);

	}

	@Override
	public void updateCalendarioCapacitacion(CalendarioCapacitacion cc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cc);
		logger.info("CalendarioCapacitacion Updated, CalendarioCapacitacion Detalle" + cc);

	}

	@Override
	public List<CalendarioCapacitacion> listCalendarioCapacitacion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CalendarioCapacitacion> listCalendarioCapacitacion = session.createQuery("from CalendarioCapacitacion order by id desc").list();
		logger.info("listCalendarioCapacitacion size: " + listCalendarioCapacitacion.size());
		return listCalendarioCapacitacion;
	}

	@Override
	public List<CalendarioCapacitacion> listCalendarioCapacitacionByCapacitacion(int capacitacion_id) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from CalendarioCapacitacion where capacitacion_id.id = :capacitacionId order by id desc";
		List<CalendarioCapacitacion> listCalendarioCapacitacion = session.createQuery(sql).setInteger("capacitacionId", capacitacion_id).list();
		logger.info("listCalendarioCapacitacion size: " + listCalendarioCapacitacion.size());
		return listCalendarioCapacitacion;
	}

	@Override
	public CalendarioCapacitacion getCalendarioCapacitacionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CalendarioCapacitacion cc = (CalendarioCapacitacion) session.load(CalendarioCapacitacion.class,
				new Integer(id));
		logger.info("CalendarioCapacitacion cargado, CalendarioCapacitacion Detalle " + cc);
		return cc;
	}

	@Override
	public void removeCalendarioCapacitacion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CalendarioCapacitacion cc = (CalendarioCapacitacion) session.load(CalendarioCapacitacion.class,
				new Integer(id));
		if (cc != null) {
			session.delete(cc);
		}
		logger.info("CalendarioCapacitacion eliminada, CalendarioCapacitacion Detalle " + cc);

	}

}
