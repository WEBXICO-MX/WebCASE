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

import mx.edu.uttab.spring.model.TipoCapacitacion;

@Repository
public class TipoCapacitacionDAOImpl implements TipoCapacitacionDAO {

	private static final Logger logger = LoggerFactory.getLogger(TipoCapacitacionDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTipoCapacitacion(TipoCapacitacion tc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(tc);
		logger.info("TipoCapacitacion saved successfully, TipoCapacitacion Details=" + tc);

	}

	@Override
	public void updateTipoCapacitacion(TipoCapacitacion tc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tc);
		logger.info("TipoCapacitacion updated successfully, TipoCapacitacion Details=" + tc);

	}

	@Override
	public List<TipoCapacitacion> listTipoCapacitacion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TipoCapacitacion> TipoCapacitacionList = session.createQuery("from TipoCapacitacion order by id desc").list();
		logger.info("TipoCapacitacionList size : " + TipoCapacitacionList.size());
		return TipoCapacitacionList;
	}

	@Override
	public TipoCapacitacion getTipoCapacitacionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TipoCapacitacion tc = (TipoCapacitacion) session.load(TipoCapacitacion.class, new Integer(id));
		logger.info("TipoCapacitacion loaded successfully, TipoCapacitacion details=" + tc);
		return tc;
	}

	@Override
	public void removeTipoCapacitacion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TipoCapacitacion tc = (TipoCapacitacion) session.load(TipoCapacitacion.class, new Integer(id));
		if (tc != null) {
			session.delete(tc);
		}
		logger.info("TipoCapacitacion deleted successfully, TipoCapacitacion details=" + tc);

	}

}
