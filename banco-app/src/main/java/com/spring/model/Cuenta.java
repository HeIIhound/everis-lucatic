package com.spring.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cuenta", catalog = "banco")
public class Cuenta implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Usuario usuario;
	private String numCuenta;
	private String nomBanco;
	private BigDecimal saldo;
	private Date fechaDeAlta;
	private Set<Movimiento> movimientos = new HashSet<Movimiento>(0);

	public Cuenta() {
	}

	public Cuenta(Usuario usuario, String numCuenta, String nomBanco, BigDecimal saldo, Date fechaDeAlta) {
		this.usuario = usuario;
		this.numCuenta = numCuenta;
		this.nomBanco = nomBanco;
		this.saldo = saldo;
		this.fechaDeAlta = fechaDeAlta;
	}

	public Cuenta(Usuario usuario, String numCuenta, String nomBanco, BigDecimal saldo, Date fechaDeAlta,
			Set<Movimiento> movimientos) {
		this.usuario = usuario;
		this.numCuenta = numCuenta;
		this.nomBanco = nomBanco;
		this.saldo = saldo;
		this.fechaDeAlta = fechaDeAlta;
		this.movimientos = movimientos;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "numCuenta", nullable = false, length = 35)
	public String getNumCuenta() {
		return this.numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	@Column(name = "nomBanco", nullable = false, length = 50)
	public String getNomBanco() {
		return this.nomBanco;
	}

	public void setNomBanco(String nomBanco) {
		this.nomBanco = nomBanco;
	}

	@Column(name = "saldo", nullable = false, precision = 22)
	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaDeAlta", nullable = false, length = 19)
	public Date getFechaDeAlta() {
		return this.fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta")
	public Set<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", usuario=" + usuario + ", numCuenta=" + numCuenta + ", nomBanco=" + nomBanco
				+ ", saldo=" + saldo + ", fechaDeAlta=" + fechaDeAlta + ", movimientos=" + "]";
	}

	
	
}
