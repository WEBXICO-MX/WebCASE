/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.model;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "calendarios_capacitaciones")
public class CalendarioCapacitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "capacitacion_id")
	private Capacitacion capacitacion_id;
	private Date fecha_inicio;
	private Date fecha_fin;
	private boolean activo;
	@JsonIgnore
	@OneToMany(mappedBy = "calendario_capacitacion_id", cascade = CascadeType.ALL)
	private List<RegistroCapacitacion> registro_capacitaciones;

	public CalendarioCapacitacion() {
		this.id = 0;
		this.capacitacion_id = null;
		this.fecha_inicio = null;
		this.fecha_fin = null;
		this.activo = true;
		this.registro_capacitaciones = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Capacitacion getCapacitacion_id() {
		return capacitacion_id;
	}

	public void setCapacitacion_id(Capacitacion capacitacion_id) {
		this.capacitacion_id = capacitacion_id;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
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
		return "CalendarioCapacitacion [id=" + id + ", capacitacion_id=" + capacitacion_id + ", fecha_inicio="
				+ fecha_inicio + ", fecha_fin=" + fecha_fin + ", activo=" + activo + "]";
	}

}