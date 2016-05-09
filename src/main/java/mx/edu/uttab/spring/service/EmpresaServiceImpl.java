/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.EmpresaDAO;
import mx.edu.uttab.spring.model.Empresa;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	private EmpresaDAO empresaDAO;

	public void setEmpresaDAO(EmpresaDAO empresaDAO) {
		this.empresaDAO = empresaDAO;
	}

	@Override
	@Transactional
	public void addEmpresa(Empresa e) {
		this.empresaDAO.addEmpresa(e);

	}

	@Override
	@Transactional
	public void updateEmpresa(Empresa e) {
		this.empresaDAO.updateEmpresa(e);

	}

	@Override
	@Transactional
	public List<Empresa> listEmpresa() {
		// TODO Auto-generated method stub
		return this.empresaDAO.listEmpresa();
	}

	@Override
	public List<Empresa> listEmpresaByActivo(boolean activo) {
		// TODO Auto-generated method stub
		return this.empresaDAO.listEmpresaByActivo(activo);
	}

	@Override
	@Transactional
	public Empresa getEmpresaById(int id) {
		// TODO Auto-generated method stub
		return this.empresaDAO.getEmpresaById(id);
	}

	@Override
	@Transactional
	public void removeEmpresa(int id) {
		this.empresaDAO.removeEmpresa(id);

	}

}
