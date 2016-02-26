/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttab.spring.dao.SectorProductivoDAO;
import mx.edu.uttab.spring.model.SectorProductivo;

@Service
public class SectorProductivoServiceImpl implements SectorProductivoService {

	private SectorProductivoDAO sectorProductivoDAO;

	public void setSectorProductivoDAO(SectorProductivoDAO sectorProductivoDAO) {
		this.sectorProductivoDAO = sectorProductivoDAO;
	}

	@Override
	@Transactional
	public void addSectorProductivo(SectorProductivo sp) {
		this.sectorProductivoDAO.addSectorProductivo(sp);

	}

	@Override
	@Transactional
	public void updateSectorProductivo(SectorProductivo sp) {
		this.sectorProductivoDAO.updateSectorProductivo(sp);

	}

	@Override
	@Transactional
	public List<SectorProductivo> listSectorProductivos() {
		return this.sectorProductivoDAO.listSectorProductivos();
	}

	@Override
	@Transactional
	public SectorProductivo getSectorProductivoById(int id) {
		return this.sectorProductivoDAO.getSectorProductivoById(id);
	}

	@Override
	@Transactional
	public void removeSectorProductivo(int id) {
		this.sectorProductivoDAO.removeSectorProductivo(id);

	}

}
