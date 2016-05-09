/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.MedioComunicacionDAO;
import mx.edu.uttab.spring.model.MedioComunicacion;

@Service
public class MedioComunicacionServiceImpl implements MedioComunicacionService {
	private MedioComunicacionDAO medioComunicacionDAO;

	public void setMedioComunicacionDAO(MedioComunicacionDAO medioComunicacionDAO) {
		this.medioComunicacionDAO = medioComunicacionDAO;
	}

	@Override
	@Transactional
	public void addMedioComunicacion(MedioComunicacion mc) {
		this.medioComunicacionDAO.addMedioComunicacion(mc);

	}

	@Override
	@Transactional
	public void updateMedioComunicacion(MedioComunicacion mc) {
		this.medioComunicacionDAO.updateMedioComunicacion(mc);

	}

	@Override
	@Transactional
	public List<MedioComunicacion> listMedioComunicacion() {
		// TODO Auto-generated method stub
		return this.medioComunicacionDAO.listMedioComunicacion();
	}

	@Override
	@Transactional
	public List<MedioComunicacion> listMedioComunicacionByPersona(int persona_id) {
		// TODO Auto-generated method stub
		return this.medioComunicacionDAO.listMedioComunicacionByPersona(persona_id);
	}

	@Override
	@Transactional
	public List<MedioComunicacion> listMedioComunicacionByActivo(boolean activo) {
		// TODO Auto-generated method stub
		return this.medioComunicacionDAO.listMedioComunicacionByActivo(activo);
	}

	@Override
	@Transactional
	public MedioComunicacion getMedioComunicacionById(int id) {
		// TODO Auto-generated method stub
		return this.medioComunicacionDAO.getMedioComunicacionById(id);
	}

	@Override
	@Transactional
	public void removeMedioComunicacion(int id) {
		this.medioComunicacionDAO.removeMedioComunicacion(id);

	}

}
