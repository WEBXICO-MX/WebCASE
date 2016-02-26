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

import mx.edu.uttab.spring.model.TipoInscripcion;

@Repository
public class TipoInscripcionDAOImpl implements TipoInscripcionDAO {

	private final static Logger logger = LoggerFactory.getLogger(TipoInscripcionDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTipoInscripcion(TipoInscripcion ti) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(ti);
		logger.info("TipoInscripcion guardado, TipoInscripcion Detalles " + ti);

	}

	@Override
	public void updateTipoInscripcion(TipoInscripcion ti) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ti);
		logger.info("TipoInscripcion Actualizado, TipoInscripcion Detalles " + ti);

	}

	@Override
	public List<TipoInscripcion> listTipoInscripcion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TipoInscripcion> listTipoInscripcion = session.createQuery("from TipoInscripcion").list();
		logger.info("listTipoInscripcion size: " + listTipoInscripcion.size());
		return listTipoInscripcion;
	}

	@Override
	public TipoInscripcion getTipoInscripcionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TipoInscripcion ti = (TipoInscripcion) session.load(TipoInscripcion.class, new Integer(id));
		logger.info("TipoInscripcion Detalle " + ti);
		return ti;
	}

	@Override
	public void removeTipoInscripcion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TipoInscripcion ti = (TipoInscripcion) session.load(TipoInscripcion.class, new Integer(id));
		if (ti != null) {
			session.delete(ti);
		}
		logger.info("TipoInscripcion eliminado, TipoInscripcion Detalles " + ti);

	}

}
