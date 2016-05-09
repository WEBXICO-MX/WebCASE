/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.StatusDAO;
import mx.edu.uttab.spring.model.Status;

@Service
public class StatusServiceImpl implements StatusService {
	private StatusDAO statusDAO;

	public void setStatusDAO(StatusDAO statusDAO) {
		this.statusDAO = statusDAO;
	}

	@Override
	@Transactional
	public void addStatus(Status s) {
		this.statusDAO.addStatus(s);

	}

	@Override
	@Transactional
	public void updateStatus(Status s) {
		this.statusDAO.updateStatus(s);

	}

	@Override
	@Transactional
	public List<Status> listStatus() {
		return this.statusDAO.listStatus();
	}

	@Override
	@Transactional
	public List<Status> listStatusByActivo(boolean activo) {
		// TODO Auto-generated method stub
		return this.statusDAO.listStatusByActivo(activo);
	}

	@Override
	@Transactional
	public Status getStatusById(int id) {
		return this.statusDAO.getStatusById(id);
	}

	@Override
	@Transactional
	public void removeStatus(int id) {
		this.statusDAO.removeStatus(id);

	}

}
