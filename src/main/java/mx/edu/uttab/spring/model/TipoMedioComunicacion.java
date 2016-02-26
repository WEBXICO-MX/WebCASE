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
@Table(name = "tipos_medios_comunicacion")
public class TipoMedioComunicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String img;
	private boolean activo;
	@OneToMany(mappedBy = "tipo_medio_comunicacion_id", cascade = CascadeType.ALL)
	private List<MedioComunicacion> medios_comunicacion;

	public TipoMedioComunicacion() {
		this.id = 0;
		this.nombre = "";
		this.img = "";
		this.activo = true;
		this.medios_comunicacion = null;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	@Override
	public String toString() {
		return "TipoMedioComunicacion [id=" + id + ", nombre=" + nombre + ", img=" + img + ", activo=" + activo + "]";
	}

}
