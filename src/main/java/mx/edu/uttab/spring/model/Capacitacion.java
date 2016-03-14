/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "capacitaciones")
public class Capacitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "tipo_capacitacion_id")
	private TipoCapacitacion tipo_capacitacion_id;
	private String nombre;
	private String descripcion;
	private boolean activo;
	@OneToMany(mappedBy = "capacitacion_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CalendarioCapacitacion> calendarios_capacitaciones;

	public Capacitacion() {
		this.id = 0;
		this.tipo_capacitacion_id = null;
		this.nombre = "";
		this.descripcion = "";
		this.activo = true;
		this.calendarios_capacitaciones = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonBackReference
	public TipoCapacitacion getTipo_capacitacion_id() {
		return tipo_capacitacion_id;
	}

	public void setTipo_capacitacion_id(TipoCapacitacion tipo_capacitacion_id) {
		this.tipo_capacitacion_id = tipo_capacitacion_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	@JsonManagedReference
	public List<CalendarioCapacitacion> getCalendarios_capacitaciones() {
		return calendarios_capacitaciones;
	}

	public void setCalendarios_capacitaciones(List<CalendarioCapacitacion> calendarios_capacitaciones) {
		this.calendarios_capacitaciones = calendarios_capacitaciones;
	}

	@Override
	public String toString() {
		return "Capacitacion [id=" + id + ", tipo_capacitacion_id=" + tipo_capacitacion_id + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", activo=" + activo + "]";
	}

}
