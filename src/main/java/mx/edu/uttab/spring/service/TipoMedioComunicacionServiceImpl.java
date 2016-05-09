/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.TipoMedioComunicacionDAO;
import mx.edu.uttab.spring.model.TipoMedioComunicacion;

@Service
public class TipoMedioComunicacionServiceImpl implements TipoMedioComunicacionService {
	private TipoMedioComunicacionDAO tipoMedioComunicacionDAO;

	public void setTipoMedioComunicacionDAO(TipoMedioComunicacionDAO tipoMedioComunicacionDAO) {
		this.tipoMedioComunicacionDAO = tipoMedioComunicacionDAO;
	}

	@Override
	@Transactional
	public void addTipoMedioComunicacion(TipoMedioComunicacion tmc) {
		this.tipoMedioComunicacionDAO.addTipoMedioComunicacion(tmc);

	}

	@Override
	@Transactional
	public void updateTipoMedioComunicacion(TipoMedioComunicacion tmc) {
		this.tipoMedioComunicacionDAO.updateTipoMedioComunicacion(tmc);

	}

	@Override
	@Transactional
	public List<TipoMedioComunicacion> listTipoMedioComunicacions() {
		return this.tipoMedioComunicacionDAO.listTipoMedioComunicacion();
	}

	@Override
	@Transactional
	public List<TipoMedioComunicacion> listTipoMedioComunicacionByActivo(boolean activo) {
		// TODO Auto-generated method stub
		return this.tipoMedioComunicacionDAO.listTipoMedioComunicacionByActivo(activo);
	}

	@Override
	@Transactional
	public TipoMedioComunicacion getTipoMedioComunicacionById(int id) {
		return this.tipoMedioComunicacionDAO.getTipoMedioComunicacionById(id);
	}

	@Override
	@Transactional
	public void removeTipoMedioComunicacion(int id) {
		this.tipoMedioComunicacionDAO.removeTipoMedioComunicacion(id);

	}

}