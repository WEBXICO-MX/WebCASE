/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.dao;

import java.util.List;

import mx.edu.uttab.spring.model.Persona;

public interface PersonaDAO {
	public void addPersona(Persona p);

	public void updatePersona(Persona p);

	public List<Persona> listPersona();
	
	public List<Persona> listPersonaByActivo(boolean activo);

	public Persona getPersonaById(int id);

	public void removePersona(int id);
}
