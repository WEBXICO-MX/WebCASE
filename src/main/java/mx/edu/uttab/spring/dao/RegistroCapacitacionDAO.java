/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.dao;

import java.util.List;

import mx.edu.uttab.spring.model.RegistroCapacitacion;

public interface RegistroCapacitacionDAO {
	public void addRegistroCapacitacion(RegistroCapacitacion rc);

	public void updateRegistroCapacitacion(RegistroCapacitacion rc);

	public List<RegistroCapacitacion> listRegistroCapacitacion();

	public RegistroCapacitacion getRegistroCapacitacionById(int id);

	public void removeRegistroCapacitacion(int id);

}
