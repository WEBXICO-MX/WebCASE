/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.PersonaDAO;
import mx.edu.uttab.spring.model.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {
	private PersonaDAO personaDAO;

	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}

	@Override
	@Transactional
	public void addPersona(Persona p) {
		this.personaDAO.addPersona(p);
	}

	@Override
	@Transactional
	public void updatePersona(Persona p) {
		this.personaDAO.updatePersona(p);
	}

	@Override
	@Transactional
	public List<Persona> listPersona() {
		return this.personaDAO.listPersona();
	}

	@Override
	@Transactional
	public Persona getPersonaById(int id) {
		return this.personaDAO.getPersonaById(id);
	}

	@Override
	@Transactional
	public void removePersona(int id) {
		this.personaDAO.removePersona(id);

	}

}
