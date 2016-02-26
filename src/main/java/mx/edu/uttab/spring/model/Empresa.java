/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "sector_productivo_id")
	private SectorProductivo sector_productivo_id;
	private String nombre;
	private boolean activo;
	@OneToMany(mappedBy = "empresa_id", cascade = CascadeType.ALL)
	private List<RegistroCapacitacion> registro_capacitaciones;

	public Empresa() {
		this.id = 0;
		this.sector_productivo_id = null;
		this.nombre = "";
		this.activo = true;
		this.registro_capacitaciones = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SectorProductivo getSector_productivo_id() {
		return sector_productivo_id;
	}

	public void setSector_productivo_id(SectorProductivo sector_productivo_id) {
		this.sector_productivo_id = sector_productivo_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<RegistroCapacitacion> getRegistro_capacitaciones() {
		return registro_capacitaciones;
	}

	public void setRegistro_capacitaciones(List<RegistroCapacitacion> registro_capacitaciones) {
		this.registro_capacitaciones = registro_capacitaciones;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", sector_productivo_id=" + sector_productivo_id + ", nombre=" + nombre
				+ ", activo=" + activo + "]";
	}

}
