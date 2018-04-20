package com.avantica.converters;

import org.springframework.stereotype.Component;

import com.avantica.entity.Clase;
import com.avantica.models.ClaseModel;

@Component("claseConverter")
public class ClaseConverter {

	public Clase convertClaseModel2Clase(ClaseModel claseModel) {
		Clase clase = new Clase();
		clase.setCodigo(claseModel.getCodigo());
		clase.setTitle(claseModel.getTitle());
		clase.setDescription(claseModel.getDescription());
		return clase;
	}
	
	public ClaseModel convertClase2ClaseModel(Clase clase) {
		ClaseModel ClaseModel = new ClaseModel();
		ClaseModel.setCodigo(clase.getCodigo());
		ClaseModel.setTitle(clase.getTitle());
		ClaseModel.setDescription(clase.getDescription());
		return ClaseModel;
	}
	
}
