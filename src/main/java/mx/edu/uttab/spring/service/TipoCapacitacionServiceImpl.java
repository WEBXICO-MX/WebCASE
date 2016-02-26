/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.TipoCapacitacionDAO;
import mx.edu.uttab.spring.model.TipoCapacitacion;

@Service
public class TipoCapacitacionServiceImpl implements TipoCapacitacionService {

	private TipoCapacitacionDAO tipoCapacitacionDAO;

	public void setTipoCapacitacionDAO(TipoCapacitacionDAO tipoCapacitacionDAO) {
		this.tipoCapacitacionDAO = tipoCapacitacionDAO;
	}

	@Override
	@Transactional
	public void addTipoCapacitacion(TipoCapacitacion tc) {
		this.tipoCapacitacionDAO.addTipoCapacitacion(tc);

	}

	@Override
	@Transactional
	public void updateTipoCapacitacion(TipoCapacitacion tc) {
		this.tipoCapacitacionDAO.updateTipoCapacitacion(tc);

	}

	@Override
	@Transactional
	public List<TipoCapacitacion> listTipoCapacitacion() {
		return this.tipoCapacitacionDAO.listTipoCapacitacion();
	}

	@Override
	@Transactional
	public TipoCapacitacion getTipoCapacitacionById(int id) {
		return this.tipoCapacitacionDAO.getTipoCapacitacionById(id);
	}

	@Override
	@Transactional
	public void removeTipoCapacitacion(int id) {
		this.tipoCapacitacionDAO.removeTipoCapacitacion(id);

	}

}
