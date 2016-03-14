/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import mx.edu.uttab.spring.model.CalendarioCapacitacion;

public interface CalendarioCapacitacionService {
	public void addCalendarioCapacitacion(CalendarioCapacitacion cc);

	public void updateCalendarioCapacitacion(CalendarioCapacitacion cc);

	public List<CalendarioCapacitacion> listCalendarioCapacitacion();
	
	public List<CalendarioCapacitacion> listCalendarioCapacitacionByCapacitacion(int capacitacion_id);

	public CalendarioCapacitacion getCalendarioCapacitacionById(int id);

	public void removeCalendarioCapacitacion(int id);

}
