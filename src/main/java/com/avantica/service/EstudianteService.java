package com.avantica.service;

import java.util.List;

import com.avantica.entity.Estudiante;
import com.avantica.models.EstudianteModel;

public interface EstudianteService {

	public abstract EstudianteModel addEstudiante(EstudianteModel estudianteModel);
	
	public abstract List<EstudianteModel> listAllEstudiantes();
	
	public abstract Estudiante findEstudianteById(int id);
	
	public abstract EstudianteModel findEstudianteByIdModel(int id);
	
	public abstract void removeEstudiante(int id);

	public abstract List<EstudianteModel> listEstudiantesByClase(String codClase);

	public abstract List<EstudianteModel> listEstudiantesSByKeyword(String keyword);
	
}
