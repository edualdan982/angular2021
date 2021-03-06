package com.spring.boot.backend.apirest.curso.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "docentes")
public class Docente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = true)
	private Long id;

	@NotEmpty
	@Size(min = 3)
	@Column(nullable = true)
	private String nombres;

	@NotEmpty
	@Size(min = 3)
	private String paterno;

	@NotEmpty
	@Size(min = 3)
	private String materno;

	@NotEmpty
	@Email
	@Column(nullable = true, unique = true)
	private String email;

	private String foto;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "docente_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Curso> cursos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String apePaterno) {
		this.paterno = apePaterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String apeMaterno) {
		this.materno = apeMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
