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

import mx.edu.uttab.spring.model.Capacitacion;

@Repository
public class CapacitacionDAOImpl implements CapacitacionDAO {
	private static final Logger logger = LoggerFactory.getLogger(CapacitacionDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCapacitacion(Capacitacion c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Capacitacion guardada, Capacitacion Detalle" + c);

	}

	@Override
	public void updateCapacitacion(Capacitacion c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Catacitacion actualizada, Capacitacion Detalle " + c);

	}

	@Override
	public List<Capacitacion> listCapacitacion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Capacitacion> listCapacitacion = session.createQuery("from Capacitacion order by id desc").list();
		logger.info("listCapacitacion size: " + listCapacitacion.size());
		return listCapacitacion;
	}

	@Override
	public List<Capacitacion> listCapacitacionByTipo(int tipo) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from Capacitacion where tipo_capacitacion_id.id =  :tipoCapacitacion order by id desc";
		List<Capacitacion> listCapacitacion = session.createQuery(sql).setInteger("tipoCapacitacion", tipo).list();
		logger.info("listCapacitacion size: " + listCapacitacion.size());
		return listCapacitacion;
	}

	@Override
	public Capacitacion getCapacitacionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Capacitacion c = (Capacitacion) session.load(Capacitacion.class, new Integer(id));
		logger.info("Capacitacion cargado, Capacitacion Detalle " + c);
		return c;
	}

	@Override
	public void removeCapacitacion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Capacitacion c = (Capacitacion) session.load(Capacitacion.class, new Integer(id));
		if (c != null) {
			session.delete(c);
		}
		logger.info("Capacitacion eliminada, Capacitacion Detalle " + c);

	}

}
