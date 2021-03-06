/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import mx.edu.uttab.spring.model.Capacitacion;

public interface CapacitacionService {
	public void addCapacitacion(Capacitacion c);

	public void updateCapacitacion(Capacitacion c);

	public List<Capacitacion> listCapacitacion();

	public List<Capacitacion> listCapacitacionByTipo(int tipo);

	public Capacitacion getCapacitacionById(int id);

	public void removeCapacitacion(int id);
}
