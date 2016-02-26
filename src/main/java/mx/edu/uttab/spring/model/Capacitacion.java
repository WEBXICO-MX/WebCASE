/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	public Capacitacion() {
		this.id = 0;
		this.tipo_capacitacion_id = null;
		this.nombre = "";
		this.descripcion = "";
		this.activo = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Capacitacion [id=" + id + ", tipo_capacitacion_id=" + tipo_capacitacion_id + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", activo=" + activo + "]";
	}

}
