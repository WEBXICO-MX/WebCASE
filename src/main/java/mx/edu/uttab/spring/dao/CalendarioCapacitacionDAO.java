/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.dao;

import java.util.List;

import mx.edu.uttab.spring.model.CalendarioCapacitacion;

public interface CalendarioCapacitacionDAO {
	public void addCalendarioCapacitacion(CalendarioCapacitacion cc);

	public void updateCalendarioCapacitacion(CalendarioCapacitacion cc);

	public List<CalendarioCapacitacion> listCalendarioCapacitacion();

	public CalendarioCapacitacion getCalendarioCapacitacionById(int id);

	public void removeCalendarioCapacitacion(int id);

}
