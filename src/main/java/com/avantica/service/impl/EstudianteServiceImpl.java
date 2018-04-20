package com.avantica.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avantica.converters.EstudianteConverter;
import com.avantica.entity.Clase;
import com.avantica.entity.Estudiante;
import com.avantica.models.EstudianteModel;
import com.avantica.service.EstudianteService;
import com.avantica.repository.ClaseRepository;
import com.avantica.repository.EstudianteRepository;
import com.avantica.repository.QueryDSLRepo;;

@Service("estudianteServiceImpl")
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	@Qualifier("estudianteRepository")
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	@Qualifier("claseRepository")
	private ClaseRepository claseRepository;
	
	@Autowired
	@Qualifier("queryDSLRepo")
	private QueryDSLRepo queryDSLRepo;
	
	@Autowired
	@Qualifier("estudianteConverter")
	private EstudianteConverter estudianteConverter;
	
	@Override
	public EstudianteModel addEstudiante(EstudianteModel estudianteModel) {
		Estudiante estudiante = estudianteRepository.save(estudianteConverter.convertEstudianteModel2Estudiante(estudianteModel));
		return estudianteConverter.convertEstudiante2EstudianteModel(estudiante);
	}

	@Override
	public List<EstudianteModel> listAllEstudiantes() {
		List<Estudiante> estudiantes = estudianteRepository.findAll();
		List<EstudianteModel> estudiantesModels = new ArrayList<EstudianteModel>(); 
		for(Estudiante estudiante : estudiantes) {
			estudiantesModels.add(estudianteConverter.convertEstudiante2EstudianteModel(estudiante));
		}
		return estudiantesModels;
	}

	@Override
	public Estudiante findEstudianteById(int id) {
		return estudianteRepository.findById(id);
	}

	@Override
	public EstudianteModel findEstudianteByIdModel(int id) {
		return estudianteConverter.convertEstudiante2EstudianteModel(findEstudianteById(id));
	}

	@Override
	public void removeEstudiante(int id) {
		Estudiante estudiante = findEstudianteById(id);
		if(estudiante!=null) {
			estudianteRepository.delete(estudiante);	
		}
	}

	@Override
	public List<EstudianteModel> listEstudiantesByClase(String codClase) {
		Clase c = claseRepository.findByCodigo(codClase);
		
		List<Estudiante> estudiantes = estudianteRepository.findAllByClases(c);
		List<EstudianteModel> estudiantesModels = new ArrayList<EstudianteModel>(); 
		for(Estudiante estudiante : estudiantes) {
			estudiantesModels.add(estudianteConverter.convertEstudiante2EstudianteModel(estudiante));
		}
		return estudiantesModels;
	}

	@Override
	public List<EstudianteModel> listEstudiantesSByKeyword(String keyword) {
//		List<Estudiante> estudiantes = estudianteRepository.findAllByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(keyword,keyword);
		List<Estudiante> estudiantes = queryDSLRepo.findEstudianteByKeyword(keyword);
		List<EstudianteModel> estudiantesModels = new ArrayList<EstudianteModel>(); 
		for(Estudiante estudiante : estudiantes) {
			estudiantesModels.add(estudianteConverter.convertEstudiante2EstudianteModel(estudiante));
		}
		return estudiantesModels;
	}

}
