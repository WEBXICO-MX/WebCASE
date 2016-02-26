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

import mx.edu.uttab.spring.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUsuario(Usuario u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		logger.info("Usuario guardado, Usuario Detalle " + u);

	}

	@Override
	public void updateUsuario(Usuario u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		logger.info("Usuario actualizado, Usuario Detalle " + u);

	}

	@Override
	public List<Usuario> listUsuario() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Usuario> listUsuario = session.createQuery("from Usuario").list();
		logger.info("listUsuario size: " + listUsuario.size());
		return listUsuario;
	}

	@Override
	public Usuario getUsuarioById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Usuario u = (Usuario) session.load(Usuario.class, new Integer(id));
		logger.info("Usuario cargado, Usuario Detalle " + u);
		return u;
	}

	@Override
	public void removeUsuario(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Usuario u = (Usuario) session.load(Usuario.class, new Integer(id));
		if (u != null) {
			session.delete(u);
		}
		logger.info("Usuario eliminado, Usuario Detalle " + u);

	}

}
