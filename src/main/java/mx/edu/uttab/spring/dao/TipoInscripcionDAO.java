/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.dao;

import java.util.List;

import mx.edu.uttab.spring.model.TipoInscripcion;

public interface TipoInscripcionDAO {
	public void addTipoInscripcion(TipoInscripcion ti);

	public void updateTipoInscripcion(TipoInscripcion ti);

	public List<TipoInscripcion> listTipoInscripcion();
	
	public List<TipoInscripcion> listTipoInscripcionByActivo(boolean activo);

	public TipoInscripcion getTipoInscripcionById(int id);

	public void removeTipoInscripcion(int id);

}
