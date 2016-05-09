/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import mx.edu.uttab.spring.model.SectorProductivo;

public interface SectorProductivoService {
	public void addSectorProductivo(SectorProductivo sp);

	public void updateSectorProductivo(SectorProductivo sp);

	public List<SectorProductivo> listSectorProductivos();
	
	public List<SectorProductivo> listSectorProductivosByActivo(boolean activo);

	public SectorProductivo getSectorProductivoById(int id);

	public void removeSectorProductivo(int id);

}
