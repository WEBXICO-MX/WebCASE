/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registros_capacitaciones")
public class RegistroCapacitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "calendario_capacitacion_id")
	private CalendarioCapacitacion calendario_capacitacion_id;
	@ManyToOne
	@JoinColumn(name = "tipo_inscripcion_id")
	private TipoInscripcion tipo_inscripcion_id;
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona_id;
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa_id;
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status_id;
	private Date fecha_registro;
	private Date fecha_modificacion;
	private boolean activo;

	public RegistroCapacitacion() {
		this.id = 0;
		this.calendario_capacitacion_id = null;
		this.tipo_inscripcion_id = null;
		this.persona_id = null;
		this.empresa_id = null;
		this.status_id = null;
		this.fecha_registro = null;
		this.fecha_modificacion = null;
		this.activo = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CalendarioCapacitacion getCalendario_capacitacion_id() {
		return calendario_capacitacion_id;
	}

	public void setCalendario_capacitacion_id(CalendarioCapacitacion calendario_capacitacion_id) {
		this.calendario_capacitacion_id = calendario_capacitacion_id;
	}

	public TipoInscripcion getTipo_inscripcion_id() {
		return tipo_inscripcion_id;
	}

	public void setTipo_inscripcion_id(TipoInscripcion tipo_inscripcion_id) {
		this.tipo_inscripcion_id = tipo_inscripcion_id;
	}

	public Persona getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(Persona persona_id) {
		this.persona_id = persona_id;
	}

	public Empresa getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(Empresa empresa_id) {
		this.empresa_id = empresa_id;
	}

	public Status getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Status status_id) {
		this.status_id = status_id;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "RegistroCapacitacion [id=" + id + ", calendario_capacitacion_id=" + calendario_capacitacion_id
				+ ", tipo_inscripcion_id=" + tipo_inscripcion_id + ", persona_id=" + persona_id + ", empresa_id="
				+ empresa_id + ", status_id=" + status_id + ", fecha_registro=" + fecha_registro
				+ ", fecha_modificacion=" + fecha_modificacion + ", activo=" + activo + "]";
	}

}
