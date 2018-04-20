package com.avantica.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_clases")
public class Clase {
	
	@Id
	@Column(name="codigo", unique=true, nullable=false)
	private String codigo;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="descripcion", nullable=false)
	private String description;
	
	@ManyToMany(mappedBy="clases")
	private List<Estudiante> estudiantes; 
	
	public Clase(String codigo, String title, String description) {
		super();
		this.codigo = codigo;
		this.title = title;
		this.description = description;
	}

	public Clase() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Clase [codigo=" + codigo + ", title=" + title + ", description=" + description + ", estudiantes="
				+ estudiantes + "]";
	}

	
	

}
