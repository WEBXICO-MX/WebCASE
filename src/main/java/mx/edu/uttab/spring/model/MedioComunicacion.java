
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
@Table(name = "medios_comunicacion")
public class MedioComunicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona_id;
	@ManyToOne
	@JoinColumn(name = "tipo_medio_comunicacion_id")
	private TipoMedioComunicacion tipo_medio_comunicacion_id;
	private String valor;
	private boolean activo;

	public MedioComunicacion() {
		this.id = 0;
		this.persona_id = null;
		this.tipo_medio_comunicacion_id = null;
		this.valor = "";
		this.activo = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(Persona persona_id) {
		this.persona_id = persona_id;
	}

	public TipoMedioComunicacion getTipo_medio_comunicacion_id() {
		return tipo_medio_comunicacion_id;
	}

	public void setTipo_medio_comunicacion_id(TipoMedioComunicacion tipo_medio_comunicacion_id) {
		this.tipo_medio_comunicacion_id = tipo_medio_comunicacion_id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "MedioComunicacion [id=" + id + ", persona_id=" + persona_id + ", tipo_medio_comunicacion_id="
				+ tipo_medio_comunicacion_id + ", valor=" + valor + ", activo=" + activo + "]";
	}

}
