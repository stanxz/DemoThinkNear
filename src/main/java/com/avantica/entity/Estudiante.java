package com.avantica.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_estudiantes")
public class Estudiante {

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	private int id;
	
	@Column(name="lastname", nullable=false)
	private String lastname;
	
	@Column(name="firstname", nullable=false)
	private String firstname;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_estudiante_clase", joinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "clase_cod", referencedColumnName = "codigo"))
	private List<Clase> clases;
	
	public Estudiante(int id, String lastname, String firstname) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public Estudiante() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + "]";
	}
	
	
}
