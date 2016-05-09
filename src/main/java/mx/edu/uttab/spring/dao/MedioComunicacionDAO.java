/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.dao;

import java.util.List;

import mx.edu.uttab.spring.model.MedioComunicacion;

public interface MedioComunicacionDAO {
	public void addMedioComunicacion(MedioComunicacion mc);

	public void updateMedioComunicacion(MedioComunicacion mc);

	public List<MedioComunicacion> listMedioComunicacion();

	public MedioComunicacion getMedioComunicacionById(int id);

	public List<MedioComunicacion> listMedioComunicacionByActivo(boolean activo);

	public List<MedioComunicacion> listMedioComunicacionByPersona(int persona_id);

	public void removeMedioComunicacion(int id);

}
