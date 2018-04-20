package com.avantica.models;

public class ClaseModel {

	private String codigo;
	private String title;
	private String description;
	
	public ClaseModel(String codigo, String title, String description) {
		super();
		this.codigo = codigo;
		this.title = title;
		this.description = description;
	}

	public ClaseModel() {
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

	@Override
	public String toString() {
		return "ClaseModel [codigo=" + codigo + ", title=" + title + ", description=" + description + "]";
	}
	
	
	
}
