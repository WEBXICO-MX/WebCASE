/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.TipoInscripcionDAO;
import mx.edu.uttab.spring.model.TipoInscripcion;

@Service
public class TipoInscripcionServiceImpl implements TipoInscripcionService {
	private TipoInscripcionDAO tipoInscripcionDAO;

	public void setTipoInscripcionDAO(TipoInscripcionDAO tipoInscripcionDAO) {
		this.tipoInscripcionDAO = tipoInscripcionDAO;
	}

	@Override
	@Transactional
	public void addTipoInscripcion(TipoInscripcion ti) {
		this.tipoInscripcionDAO.addTipoInscripcion(ti);

	}

	@Override
	@Transactional
	public void updateTipoInscripcion(TipoInscripcion ti) {
		this.tipoInscripcionDAO.updateTipoInscripcion(ti);

	}

	@Override
	@Transactional
	public List<TipoInscripcion> listTipoInscripcions() {
		return this.tipoInscripcionDAO.listTipoInscripcion();
	}

	@Override
	@Transactional
	public List<TipoInscripcion> listTipoInscripcionsByActivo(boolean activo) {
		// TODO Auto-generated method stub
		return this.tipoInscripcionDAO.listTipoInscripcionByActivo(activo);
	}

	@Override
	@Transactional
	public TipoInscripcion getTipoInscripcionById(int id) {
		return this.tipoInscripcionDAO.getTipoInscripcionById(id);
	}

	@Override
	@Transactional
	public void removeTipoInscripcion(int id) {
		this.tipoInscripcionDAO.removeTipoInscripcion(id);

	}

}
