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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private Date fecha_nacimiento;
	private String sexo;
	private boolean activo;
	@OneToMany(mappedBy = "persona_id", cascade = CascadeType.ALL)
	private List<MedioComunicacion> medios_comunicacion;
	@OneToMany(mappedBy = "persona_id", cascade = CascadeType.ALL)
	private List<RegistroCapacitacion> registro_capacitaciones;

	public Persona() {
		this.id = 0;
		this.nombre = "";
		this.ap_paterno = "";
		this.ap_materno = "";
		this.fecha_nacimiento = null;
		this.sexo = "";
		this.activo = true;
		this.medios_comunicacion = null;
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

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<MedioComunicacion> getMedios_comunicacion() {
		return medios_comunicacion;
	}

	public void setMedios_comunicacion(List<MedioComunicacion> medios_comunicacion) {
		this.medios_comunicacion = medios_comunicacion;
	}

	public List<RegistroCapacitacion> getRegistro_capacitaciones() {
		return registro_capacitaciones;
	}

	public void setRegistro_capacitaciones(List<RegistroCapacitacion> registro_capacitaciones) {
		this.registro_capacitaciones = registro_capacitaciones;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", ap_paterno=" + ap_paterno + ", ap_materno=" + ap_materno
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", sexo=" + sexo + ", activo=" + activo + "]";
	}

}
