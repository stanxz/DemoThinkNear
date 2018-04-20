package com.avantica.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avantica.entity.Clase;
import com.avantica.entity.Estudiante;

@Repository("claseRepository")
public interface ClaseRepository extends JpaRepository<Clase, Serializable>{
	public abstract Clase findByCodigo(String codigo);
	
	public abstract List<Clase> findAllByEstudiantes(Estudiante estudiante);
	
	public abstract List<Clase> findAllByCodigoContainingIgnoreCaseOrTitleContainingIgnoreCase(String codigo, String nombre);
	
}
