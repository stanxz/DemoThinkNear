package com.avantica.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avantica.converters.ClaseConverter;
import com.avantica.entity.Clase;
import com.avantica.entity.Estudiante;
import com.avantica.models.ClaseModel;
import com.avantica.repository.ClaseRepository;
import com.avantica.repository.EstudianteRepository;
import com.avantica.repository.QueryDSLRepo;
import com.avantica.service.ClaseService;

@Service("claseServiceImpl")
public class ClaseServiceImpl implements ClaseService{

	
	@Autowired
	@Qualifier("queryDSLRepo")
	private QueryDSLRepo queryDSLRepo;
	
	@Autowired
	@Qualifier("claseRepository")
	private ClaseRepository claseRepository;
	
	@Autowired
	@Qualifier("estudianteRepository")
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	@Qualifier("claseConverter")
	private ClaseConverter claseConverter;
	
	@Override
	public ClaseModel addClase(ClaseModel claseModel) {
		Clase clase = claseRepository.save(claseConverter.convertClaseModel2Clase(claseModel));
		return claseConverter.convertClase2ClaseModel(clase);
	}

	@Override
	public List<ClaseModel> listAllClases() {
		List<Clase> clases = claseRepository.findAll();
		List<ClaseModel> clasesModels = new ArrayList<ClaseModel>(); 
		for(Clase clase : clases) {
			clasesModels.add(claseConverter.convertClase2ClaseModel(clase));
		}
		return clasesModels;
	}


	
	@Override
	public Clase findClaseByCodigo(String codigo) {
		return claseRepository.findByCodigo(codigo);
	}

	@Override
	public ClaseModel findClaseByIdModel(String codigo) {
		return claseConverter.convertClase2ClaseModel(findClaseByCodigo(codigo));
	}

	@Override
	public void removeClase(String codigo) {
		Clase clase = findClaseByCodigo(codigo);
		if(clase!=null) {
			claseRepository.delete(clase);	
		}
	}

	@Override
	public List<ClaseModel> listClasesByEstudiante(int idEstudiante) {
		Estudiante e = estudianteRepository.findById(idEstudiante);
		
		List<Clase> clases = claseRepository.findAllByEstudiantes(e);
		List<ClaseModel> clasesModels = new ArrayList<ClaseModel>(); 
		for(Clase clase : clases) {
			clasesModels.add(claseConverter.convertClase2ClaseModel(clase));
		}
		return clasesModels;
	}

	@Override
	public List<ClaseModel> listClasesByKeyword(String keyword) {
//		List<Clase> clases = claseRepository.findAllByCodigoContainingIgnoreCaseOrTitleContainingIgnoreCase(keyword,keyword);
		List<Clase> clases = queryDSLRepo.findClaseByKeyword(keyword);
		List<ClaseModel> clasesModels = new ArrayList<ClaseModel>(); 
		for(Clase clase : clases) {
			clasesModels.add(claseConverter.convertClase2ClaseModel(clase));
		}
		return clasesModels;
	}

}
