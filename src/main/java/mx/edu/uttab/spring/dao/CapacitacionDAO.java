/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.dao;

import java.util.List;

import mx.edu.uttab.spring.model.Capacitacion;

public interface CapacitacionDAO {
	public void addCapacitacion(Capacitacion c);

	public void updateCapacitacion(Capacitacion c);

	public List<Capacitacion> listCapacitacion();

	public Capacitacion getCapacitacionById(int id);

	public void removeCapacitacion(int id);

}
