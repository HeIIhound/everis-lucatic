package com.spring.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario", catalog = "banco", uniqueConstraints = @UniqueConstraint(columnNames = "dni"))
public class Usuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String apellido;
	private String dni;
	private Set<Usuariologin> usuariologins = new HashSet<Usuariologin>(0);
	private Set<Cuenta> cuentas = new HashSet<Cuenta>(0);

	public Usuario() {
	}

	public Usuario(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public Usuario(String nombre, String apellido, String dni, Set<Usuariologin> usuariologins, Set<Cuenta> cuentas) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.usuariologins = usuariologins;
		this.cuentas = cuentas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", nullable = false, length = 50)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "dni", unique = true, nullable = false, length = 9)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Usuariologin> getUsuariologins() {
		return this.usuariologins;
	}

	public void setUsuariologins(Set<Usuariologin> usuariologins) {
		this.usuariologins = usuariologins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}
