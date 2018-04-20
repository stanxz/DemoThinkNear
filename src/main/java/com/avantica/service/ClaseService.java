package com.avantica.service;

import java.util.List;

import com.avantica.entity.Clase;
import com.avantica.models.ClaseModel;

public interface ClaseService {

	public abstract ClaseModel addClase(ClaseModel claseModel);
	
	public abstract List<ClaseModel> listAllClases();
	
	public abstract Clase findClaseByCodigo(String codigo);
	
	public abstract ClaseModel findClaseByIdModel(String codigo);
	
	public abstract void removeClase(String codigo);

	public abstract List<ClaseModel> listClasesByEstudiante(int idEstudiante);

	public abstract List<ClaseModel> listClasesByKeyword(String keyword);
	
}
