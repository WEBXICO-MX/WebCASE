/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import mx.edu.uttab.spring.model.TipoMedioComunicacion;

public interface TipoMedioComunicacionService {
	public void addTipoMedioComunicacion(TipoMedioComunicacion tmc);

	public void updateTipoMedioComunicacion(TipoMedioComunicacion tmc);

	public List<TipoMedioComunicacion> listTipoMedioComunicacions();

	public List<TipoMedioComunicacion> listTipoMedioComunicacionByActivo(boolean activo);

	public TipoMedioComunicacion getTipoMedioComunicacionById(int id);

	public void removeTipoMedioComunicacion(int id);

}