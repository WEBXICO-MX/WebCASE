/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.CapacitacionDAO;
import mx.edu.uttab.spring.model.Capacitacion;

@Service
public class CapacitacionServiceImpl implements CapacitacionService {
	private CapacitacionDAO capacitacionDAO;

	public void setCapacitacionDAO(CapacitacionDAO capacitacionDAO) {
		this.capacitacionDAO = capacitacionDAO;
	}

	@Override
	@Transactional
	public void addCapacitacion(Capacitacion c) {
		this.capacitacionDAO.addCapacitacion(c);

	}

	@Override
	@Transactional
	public void updateCapacitacion(Capacitacion c) {
		this.capacitacionDAO.updateCapacitacion(c);

	}

	@Override
	@Transactional
	public List<Capacitacion> listCapacitacion() {
		return this.capacitacionDAO.listCapacitacion();
	}

	@Override
	@Transactional
	public Capacitacion getCapacitacionById(int id) {
		return this.capacitacionDAO.getCapacitacionById(id);
	}

	@Override
	@Transactional
	public void removeCapacitacion(int id) {
		this.capacitacionDAO.removeCapacitacion(id);

	}

}
