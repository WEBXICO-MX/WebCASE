/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import mx.edu.uttab.spring.model.TipoInscripcion;

public interface TipoInscripcionService {
	public void addTipoInscripcion(TipoInscripcion ti);

	public void updateTipoInscripcion(TipoInscripcion ti);

	public List<TipoInscripcion> listTipoInscripcions();

	public TipoInscripcion getTipoInscripcionById(int id);

	public void removeTipoInscripcion(int id);

}
