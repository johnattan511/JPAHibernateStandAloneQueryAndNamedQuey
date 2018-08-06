package POJOS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "retornarNombresEstudiantes", query = "SELECT e.nombre from Estudiante e"),
		@NamedQuery(name = "retornarNombresEstudiantesPorId", query = "SELECT e.nombre from Estudiante e WHERE e.id = :id") })

public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String telefono;
	private String correo;

	public Estudiante() {
		super();
	}

	public Estudiante(int id, String nombre, String telefono, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "[id=" + getId() + " nombre=" + getNombre() + " telefono=" + getTelefono() + " correo=" + getCorreo()
				+ "]";
	}

}
