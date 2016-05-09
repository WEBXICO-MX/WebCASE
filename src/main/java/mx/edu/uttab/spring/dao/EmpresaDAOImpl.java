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

import mx.edu.uttab.spring.model.Empresa;

@Repository
public class EmpresaDAOImpl implements EmpresaDAO {
	private static final Logger logger = LoggerFactory.getLogger(EmpresaDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmpresa(Empresa e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		logger.info("Empresa saved successfully, Empresa Details=" + e);

	}

	@Override
	public void updateEmpresa(Empresa e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		logger.info("Empresa Updated successfully, Empresa Details=" + e);

	}

	@Override
	public List<Empresa> listEmpresa() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Empresa> EmpresaList = session.createQuery("from Empresa order by id desc").list();
		return EmpresaList;
	}

	@Override
	public List<Empresa> listEmpresaByActivo(boolean activo) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from Empresa where activo = :activo order by nombre";
		Query q = session.createQuery(sql);
		q.setBoolean("activo", activo);
		List<Empresa> EmpresaList = q.list();
		return EmpresaList;
	}

	@Override
	public Empresa getEmpresaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Empresa e = (Empresa) session.load(Empresa.class, new Integer(id));
		logger.info("Empresa loaded successfully, Empresa details=" + e);
		return e;
	}

	@Override
	public void removeEmpresa(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Empresa e = (Empresa) session.load(Empresa.class, new Integer(id));
		if (null != e) {
			session.delete(e);
		}
		logger.info("Empresa deleted successfully, Empresa details=" + e);

	}

}
