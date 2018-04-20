package com.avantica.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avantica.entity.Clase;
import com.avantica.entity.Estudiante;

@Repository("estudianteRepository")
public interface EstudianteRepository extends JpaRepository<Estudiante, Serializable>{

	public abstract Estudiante findById(int id);
	
	public abstract List<Estudiante> findAllByClases(Clase clase);
	
	public abstract List<Estudiante> findAllByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String nombre, String apellido);
	
}
