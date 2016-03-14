/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.CalendarioCapacitacionDAO;
import mx.edu.uttab.spring.model.CalendarioCapacitacion;

@Service
public class CalendarioCapacitacionServiceImpl implements CalendarioCapacitacionService {
	private CalendarioCapacitacionDAO calendarioCursoDAO;

	public void setCalendarioCapacitacionDAO(CalendarioCapacitacionDAO calendarioCursoDAO) {
		this.calendarioCursoDAO = calendarioCursoDAO;
	}

	@Override
	@Transactional
	public void addCalendarioCapacitacion(CalendarioCapacitacion cc) {
		this.calendarioCursoDAO.addCalendarioCapacitacion(cc);

	}

	@Override
	@Transactional
	public void updateCalendarioCapacitacion(CalendarioCapacitacion cc) {
		this.calendarioCursoDAO.updateCalendarioCapacitacion(cc);

	}

	@Override
	@Transactional
	public List<CalendarioCapacitacion> listCalendarioCapacitacion() {
		return this.calendarioCursoDAO.listCalendarioCapacitacion();
	}

	@Override
	@Transactional
	public List<CalendarioCapacitacion> listCalendarioCapacitacionByCapacitacion(int capacitacion_id) {
		// TODO Auto-generated method stub
		return this.calendarioCursoDAO.listCalendarioCapacitacionByCapacitacion(capacitacion_id);
	}

	@Override
	@Transactional
	public CalendarioCapacitacion getCalendarioCapacitacionById(int id) {
		return this.calendarioCursoDAO.getCalendarioCapacitacionById(id);
	}

	@Override
	@Transactional
	public void removeCalendarioCapacitacion(int id) {
		this.calendarioCursoDAO.removeCalendarioCapacitacion(id);

	}

}
