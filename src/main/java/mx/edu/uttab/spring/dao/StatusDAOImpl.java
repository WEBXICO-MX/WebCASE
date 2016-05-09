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

import mx.edu.uttab.spring.model.Status;

@Repository
public class StatusDAOImpl implements StatusDAO {
	private static final Logger logger = LoggerFactory.getLogger(StatusDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addStatus(Status s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(s);
		logger.info("Status guardado, Status Detalle " + s);

	}

	@Override
	public void updateStatus(Status s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
		logger.info("Status actualizado, Status Detalle " + s);

	}

	@Override
	public List<Status> listStatus() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Status> listStatus = session.createQuery("from Status order by id desc").list();
		return listStatus;
	}

	@Override
	public List<Status> listStatusByActivo(boolean activo) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from Status where activo = :activo order by nombre";
		Query q = session.createQuery(sql);
		q.setBoolean("activo", activo);
		List<Status> listStatus = q.list();
		return listStatus;
	}

	@Override
	public Status getStatusById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Status s = (Status) session.load(Status.class, new Integer(id));
		logger.info("Status cargado, Status Detalle " + s);
		return s;
	}

	@Override
	public void removeStatus(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Status s = (Status) session.load(Status.class, new Integer(id));
		if (s != null) {
			session.delete(s);
		}
		logger.info("Status eliminado, Status Detalle " + s);

	}

}
