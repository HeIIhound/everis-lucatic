package com.spring.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuariologin", catalog = "banco", uniqueConstraints = @UniqueConstraint(columnNames = "user"))
public class Usuariologin implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Usuario usuario;
	private String user;
	private String pass;
	private Date ultimoAcceso;

	public Usuariologin() {
	}

	public Usuariologin(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	
	public Usuariologin(Usuario usuario, String user, String pass, Date ultimoAcceso) {
		this.usuario = usuario;
		this.user = user;
		this.pass = pass;
		this.ultimoAcceso = ultimoAcceso;
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

	@Column(name = "user", unique = true, nullable = false, length = 50)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "pass", nullable = false, length = 50)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimoAcceso", nullable = false, length = 19)
	public Date getUltimoAcceso() {
		return this.ultimoAcceso;
	}

	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	@Override
	public String toString() {
		return "Usuariologin [id=" + id + ", usuario=" + usuario + ", user=" + user + ", pass=" + pass
				+ ", ultimoAcceso=" + ultimoAcceso + "]";
	}
	
	

	
}
