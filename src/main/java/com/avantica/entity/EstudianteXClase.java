package com.avantica.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_estudiante_clase")
public class EstudianteXClase {

	 @EmbeddedId EstudianteXClaseId id;

//	@Id
//	@Column(name="estudiante_id", nullable=false)
//	private int estudiante_id;
//	
//	@Id
//	@Column(name="clase_cod", nullable=false)
//	private String clase_cod;
//	
//	public EstudianteXClase(int estudiante_id, String clase_cod) {
//		super();
//		this.estudiante_id = estudiante_id;
//		this.clase_cod = clase_cod;
//	}
//
//	public EstudianteXClase() {
//		super();
//	}
//
//	public int getEstudiante_id() {
//		return estudiante_id;
//	}
//
//	public void setEstudiante_id(int estudiante_id) {
//		this.estudiante_id = estudiante_id;
//	}
//
//	public String getClase_cod() {
//		return clase_cod;
//	}
//
//	public void setClase_cod(String clase_cod) {
//		this.clase_cod = clase_cod;
//	}
//
//	@Override
//	public String toString() {
//		return "EstudianteXClase [estudiante_id=" + estudiante_id + ", clase_cod=" + clase_cod + "]";
//	}
	
};

@Embeddable
class EstudianteXClaseId implements Serializable{

	@Column(name="estudiante_id", nullable=false)
	private int estudiante_id;
	
	@Column(name="clase_cod", nullable=false)
	private String clase_cod;

	

	public EstudianteXClaseId(int estudiante_id, String clase_cod) {
		super();
		this.estudiante_id = estudiante_id;
		this.clase_cod = clase_cod;
	}

	
	
	public EstudianteXClaseId() {
		super();
	}



	public int getEstudiante_id() {
		return estudiante_id;
	}

	public void setEstudiante_id(int estudiante_id) {
		this.estudiante_id = estudiante_id;
	}

	public String getClase_cod() {
		return clase_cod;
	}

	public void setClase_cod(String clase_cod) {
		this.clase_cod = clase_cod;
	}

	@Override
	public String toString() {
		return "EstudianteXClaseId [estudiante_id=" + estudiante_id + ", clase_cod=" + clase_cod + "]";
	}
	
	
}
