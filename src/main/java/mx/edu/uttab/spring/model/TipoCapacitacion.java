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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_capacitaciones")
public class TipoCapacitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private boolean activo;

	@OneToMany(mappedBy = "tipo_capacitacion_id", cascade = CascadeType.ALL)
	private List<Capacitacion> capacitaciones;

	public TipoCapacitacion() {
		this.id = 0;
		this.nombre = "";
		this.activo = true;
		this.capacitaciones = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Capacitacion> getCapacitaciones() {
		return capacitaciones;
	}

	public void setCapacitaciones(List<Capacitacion> capacitaciones) {
		this.capacitaciones = capacitaciones;
	}

	@Override
	public String toString() {
		return "TipoCapacitacion [id=" + id + ", nombre=" + nombre + ", activo=" + activo + "]";
	}

}
