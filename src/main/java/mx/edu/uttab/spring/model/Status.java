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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "status")
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private boolean activo;
	@JsonIgnore
	@OneToMany(mappedBy = "status_id", cascade = CascadeType.ALL)
	private List<RegistroCapacitacion> registro_capacitaciones;

	public Status() {
		this.id = 0;
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
		return "Status [id=" + id + ", nombre=" + nombre + ", activo=" + activo + "]";
	}

}
