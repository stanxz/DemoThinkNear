package com.avantica.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.avantica.entity.Clase;
import com.avantica.entity.Estudiante;
import com.avantica.entity.QClase;
import com.avantica.entity.QEstudiante;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLRepo")
public class QueryDSLRepo {

	private QClase qClase = QClase.clase;
	private QEstudiante qEstudiante = QEstudiante.estudiante;
	
	@PersistenceContext
	private EntityManager em;
	

	public List<Clase> findClaseByKeyword(String keyword){

		JPAQuery<Clase> query = new JPAQuery<Clase>(em);

//		List<Clase> lista = (List<Clase>) query.select(qClase).from(qClase).where(qClase.codigo.likeIgnoreCase(keyword).or(qClase.title.likeIgnoreCase(keyword))).fetch();
		
//		List<Clase> lista = (List<Clase>) query.select(qClase).from(qClase).where(qClase.codigo.startsWithIgnoreCase(keyword).or(qClase.title.startsWithIgnoreCase(keyword))).fetch();
		
		List<Clase> lista = (List<Clase>) query.select(qClase).from(qClase).where(qClase.codigo.containsIgnoreCase(keyword).or(qClase.title.containsIgnoreCase(keyword))).fetch();
		
		return lista;
		
	}
	

	public List<Estudiante> findEstudianteByKeyword(String keyword){

		JPAQuery<Estudiante> query = new JPAQuery<Estudiante>(em);

//		List<Estudiante> lista = (List<Estudiante>) query.select(qEstudiante).from(qEstudiante).where(qEstudiante.firstname.likeIgnoreCase(keyword).or(qEstudiante.lastname.likeIgnoreCase(keyword))).fetch();
		
//		List<Estudiante> lista = (List<Estudiante>) query.select(qEstudiante).from(qEstudiante).where(qEstudiante.firstname.startsWithIgnoreCase(keyword).or(qEstudiante.lastname.startsWithIgnoreCase(keyword))).fetch();
		
		List<Estudiante> lista = (List<Estudiante>) query.select(qEstudiante).from(qEstudiante).where(qEstudiante.firstname.containsIgnoreCase(keyword).or(qEstudiante.lastname.containsIgnoreCase(keyword))).fetch();
		
		return lista;
		
	}
	
}
