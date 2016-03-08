/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.RegistroCapacitacionDAO;
import mx.edu.uttab.spring.model.RegistroCapacitacion;

@Service
public class RegistroCapacitacionServiceImpl implements RegistroCapacitacionService {
	private RegistroCapacitacionDAO registroCapacitacionDAO;

	public void setRegistroCapacitacionDAO(RegistroCapacitacionDAO registroCapacitacionDAO) {
		this.registroCapacitacionDAO = registroCapacitacionDAO;
	}

	@Override
	@Transactional
	public void addRegistroCapacitacion(RegistroCapacitacion rc) {
		this.registroCapacitacionDAO.addRegistroCapacitacion(rc);

	}

	@Override
	@Transactional
	public void updateRegistroCapacitacion(RegistroCapacitacion rc) {
		this.registroCapacitacionDAO.updateRegistroCapacitacion(rc);

	}

	@Override
	@Transactional
	public List<RegistroCapacitacion> listRegistroCapacitacion() {
		// TODO Auto-generated method stub
		return this.registroCapacitacionDAO.listRegistroCapacitacion();
	}

	@Override
	@Transactional
	public List<RegistroCapacitacion> listRegistroCapacitacionByStatus(int status) {
		// TODO Auto-generated method stub
		return this.registroCapacitacionDAO.listRegistroCapacitacionByStatus(status);
	}

	@Override
	@Transactional
	public RegistroCapacitacion getRegistroCapacitacionById(int id) {
		// TODO Auto-generated method stub
		return this.registroCapacitacionDAO.getRegistroCapacitacionById(id);
	}

	@Override
	@Transactional
	public void removeRegistroCapacitacion(int id) {
		// TODO Auto-generated method stub
		this.registroCapacitacionDAO.removeRegistroCapacitacion(id);

	}

}
