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

import mx.edu.uttab.spring.model.SectorProductivo;

@Repository
public class SectorProductivoImpl implements SectorProductivoDAO {

	private static final Logger logger = LoggerFactory.getLogger(SectorProductivoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addSectorProductivo(SectorProductivo sp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sp);
		logger.info("SectorProductivo saved successfully, SectorProductivo Details=" + sp);

	}

	@Override
	public void updateSectorProductivo(SectorProductivo sp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sp);
		logger.info("SectorProductivo updated successfully, SectorProductivo Details=" + sp);

	}

	@Override
	public List<SectorProductivo> listSectorProductivos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SectorProductivo> SectorProductivoList = session.createQuery("from SectorProductivo order by id desc").list();
		for (SectorProductivo sp : SectorProductivoList) {
			logger.info("SectorProductivo List::" + sp);
		}
		return SectorProductivoList;
	}

	@Override
	public List<SectorProductivo> listSectorProductivosByActivo(boolean activo) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from SectorProductivo where activo = :activo order by nombre";
		Query q = session.createQuery(sql);
		q.setBoolean("activo", activo);
		List<SectorProductivo> SectorProductivoList = q.list();
		for (SectorProductivo sp : SectorProductivoList) {
			logger.info("SectorProductivo List::" + sp);
		}
		return SectorProductivoList;
	}

	@Override
	public SectorProductivo getSectorProductivoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SectorProductivo sp = (SectorProductivo) session.load(SectorProductivo.class, new Integer(id));
		logger.info("SectorProductivo loaded successfully, SectorProductivo details=" + sp);
		return sp;
	}

	@Override
	public void removeSectorProductivo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SectorProductivo sp = (SectorProductivo) session.load(SectorProductivo.class, new Integer(id));
		if (null != sp) {
			session.delete(sp);
		}
		logger.info("SectorProductivo deleted successfully, SectorProductivo details=" + sp);

	}

}
