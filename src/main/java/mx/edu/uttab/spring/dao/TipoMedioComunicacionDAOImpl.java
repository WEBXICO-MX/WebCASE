/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import mx.edu.uttab.spring.model.TipoMedioComunicacion;

@Repository
public class TipoMedioComunicacionDAOImpl implements TipoMedioComunicacionDAO {
	private final static Logger logger = LoggerFactory.getLogger(TipoMedioComunicacionDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTipoMedioComunicacion(TipoMedioComunicacion tmc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(tmc);
		logger.info("TipoMedioComunicacion guardado, TipoMedioComunicacion Detalles " + tmc);

	}

	@Override
	public void updateTipoMedioComunicacion(TipoMedioComunicacion tmc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tmc);
		logger.info("TipoMedioComunicacion Actualizado, TipoMedioComunicacion Detalles " + tmc);

	}

	@Override
	public List<TipoMedioComunicacion> listTipoMedioComunicacion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TipoMedioComunicacion> listTipoMedioComunicacion = session.createQuery("from TipoMedioComunicacion order by id desc").list();
		logger.info("listTipoMedioComunicacion size: " + listTipoMedioComunicacion.size());
		return listTipoMedioComunicacion;
	}

	@Override
	public List<TipoMedioComunicacion> listTipoMedioComunicacionByActivo(boolean activo) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from TipoMedioComunicacion where activo = :activo order by nombre";
		Query q = session.createQuery(sql);
		q.setBoolean("activo", activo);
		List<TipoMedioComunicacion> listTipoMedioComunicacion = q.list();
		logger.info("listTipoMedioComunicacion size: " + listTipoMedioComunicacion.size());
		return listTipoMedioComunicacion;
	}

	@Override
	public TipoMedioComunicacion getTipoMedioComunicacionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TipoMedioComunicacion tmc = (TipoMedioComunicacion) session.load(TipoMedioComunicacion.class, new Integer(id));
		logger.info("TipoMedioComunicacion Detalle " + tmc);
		return tmc;
	}

	@Override
	public void removeTipoMedioComunicacion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TipoMedioComunicacion tmc = (TipoMedioComunicacion) session.load(TipoMedioComunicacion.class, new Integer(id));
		if (tmc != null) {
			session.delete(tmc);
		}
		logger.info("TipoMedioComunicacion eliminado, TipoMedioComunicacion Detalles " + tmc);

	}

}
