/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.dao;

import java.util.List;

import mx.edu.uttab.spring.model.SectorProductivo;

public interface SectorProductivoDAO {
	public void addSectorProductivo(SectorProductivo p);

	public void updateSectorProductivo(SectorProductivo p);

	public List<SectorProductivo> listSectorProductivos();
	
	public List<SectorProductivo> listSectorProductivosByActivo(boolean activo);

	public SectorProductivo getSectorProductivoById(int id);

	public void removeSectorProductivo(int id);

}
