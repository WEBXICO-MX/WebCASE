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

import mx.edu.uttab.spring.model.MedioComunicacion;

@Repository
public class MedioComunicacionDAOImpl implements MedioComunicacionDAO {
	private static final Logger logger = LoggerFactory.getLogger(MedioComunicacionDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addMedioComunicacion(MedioComunicacion mc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(mc);
		logger.info("MedioComunicacion saved successfully, MedioComunicacion Details=" + mc);

	}

	@Override
	public void updateMedioComunicacion(MedioComunicacion mc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(mc);
		logger.info("MedioComunicacion Updated successfully, MedioComunicacion Details=" + mc);

	}

	@Override
	public List<MedioComunicacion> listMedioComunicacion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<MedioComunicacion> MedioComunicacionList = session.createQuery("from MedioComunicacion").list();
		for (MedioComunicacion mc : MedioComunicacionList) {
			logger.info("MedioComunicacion List::" + mc);
		}
		return MedioComunicacionList;
	}

	@Override
	public List<MedioComunicacion> listMedioComunicacionByPersona(int persona_id) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from MedioComunicacion where persona_id.id = :personaId";
		List<MedioComunicacion> MedioComunicacionList = session.createQuery(sql).setInteger("personaId", persona_id).list();
		for (MedioComunicacion mc : MedioComunicacionList) {
			logger.info("MedioComunicacion List::" + mc);
		}
		return MedioComunicacionList;
	}

	@Override
	public MedioComunicacion getMedioComunicacionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		MedioComunicacion mc = (MedioComunicacion) session.load(MedioComunicacion.class, new Integer(id));
		logger.info("MedioComunicacion loaded successfully, MedioComunicacion details=" + mc);
		return mc;
	}

	@Override
	public void removeMedioComunicacion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		MedioComunicacion mc = (MedioComunicacion) session.load(MedioComunicacion.class, new Integer(id));
		if (null != mc) {
			session.delete(mc);
		}
		logger.info("MedioComunicacion deleted successfully, MedioComunicacion details=" + mc);

	}

}
