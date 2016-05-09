/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import mx.edu.uttab.spring.model.TipoCapacitacion;

public interface TipoCapacitacionService {
	public void addTipoCapacitacion(TipoCapacitacion tc);

	public void updateTipoCapacitacion(TipoCapacitacion tc);

	public List<TipoCapacitacion> listTipoCapacitacion();
	
	public List<TipoCapacitacion> listTipoCapacitacionByActivo(boolean activo);

	public TipoCapacitacion getTipoCapacitacionById(int id);

	public void removeTipoCapacitacion(int id);

}
