package com.avantica.converters;

import org.springframework.stereotype.Component;

import com.avantica.entity.Estudiante;
import com.avantica.models.EstudianteModel;

@Component("estudianteConverter")
public class EstudianteConverter {

	public Estudiante convertEstudianteModel2Estudiante(EstudianteModel estudianteModel) {
		Estudiante estudiante = new Estudiante();
		estudiante.setId(estudianteModel.getId());
		estudiante.setFirstname(estudianteModel.getFirstname());
		estudiante.setLastname(estudianteModel.getLastname());
		return estudiante;
	}
	
	public EstudianteModel convertEstudiante2EstudianteModel(Estudiante estudiante) {
		EstudianteModel estudianteModel = new EstudianteModel();
		estudianteModel.setId(estudiante.getId());
		estudianteModel.setFirstname(estudiante.getFirstname());
		estudianteModel.setLastname(estudiante.getLastname());
		return estudianteModel;
	}
	
}
