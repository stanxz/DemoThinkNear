package com.avantica.models;

public class EstudianteModel {

	private int id;
	private String lastname;
	private String firstname;
	
	public EstudianteModel(int id, String lastname, String firstname) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
	}
	
	public EstudianteModel() {
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

	@Override
	public String toString() {
		return "EstudianteModel [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + "]";
	}
	
	
}
