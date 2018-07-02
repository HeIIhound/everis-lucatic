package spring.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "movimiento", catalog = "banco")
public class Movimiento implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Cuenta cuenta;
	private Date fechaOperacion;
	private BigDecimal cantidad;
	private String tipoOperacion;

	
	
	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", fechaOperacion=" + fechaOperacion + ", cantidad="
				+ cantidad + ", tipoOperacion=" + tipoOperacion + "]";
	}

	public Movimiento() {
	}

	public Movimiento(Cuenta cuenta, Date fechaOperacion, BigDecimal cantidad) {
		this.cuenta = cuenta;
		this.fechaOperacion = fechaOperacion;
		this.cantidad = cantidad;
	}

	public Movimiento(Cuenta cuenta, Date fechaOperacion, BigDecimal cantidad, String tipoOperacion) {
		this.cuenta = cuenta;
		this.fechaOperacion = fechaOperacion;
		this.cantidad = cantidad;
		this.tipoOperacion = tipoOperacion;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcuenta", nullable = false)
	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaoperacion", nullable = false, length = 19)
	public Date getFechaOperacion() {
		return this.fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	@Column(name = "cantidad", nullable = false, precision = 12)
	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "tipooperacion", length = 45)
	public String getTipoOperacion() {
		return this.tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

}
