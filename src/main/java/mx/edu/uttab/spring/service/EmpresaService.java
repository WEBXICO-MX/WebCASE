/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import mx.edu.uttab.spring.model.Empresa;

public interface EmpresaService {
	public void addEmpresa(Empresa e);

	public void updateEmpresa(Empresa e);

	public List<Empresa> listEmpresa();

	public Empresa getEmpresaById(int id);

	public void removeEmpresa(int id);
}
