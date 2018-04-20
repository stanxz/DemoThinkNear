package com.avantica.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avantica.constant.ViewConstant;
import com.avantica.models.EstudianteModel;
import com.avantica.service.EstudianteService;

@Controller
@RequestMapping("/students")
public class EstudianteController {

	private static final Log LOG = LogFactory.getLog(EstudianteController.class);
	
	@Autowired
	@Qualifier("estudianteServiceImpl")
	private EstudianteService estudianteService;
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/students/showstudents"; 
	}
	
	@GetMapping("/studentform")
	private String redirectEstudianteForm(@RequestParam(name="idStudent", required=false) int id,
			Model model) {
		
		EstudianteModel estudiante=new EstudianteModel();
		if(id != 0 ) {
			estudiante=estudianteService.findEstudianteByIdModel(id);
		}
		
		model.addAttribute("estudianteModel",estudiante);
		return ViewConstant.ESTUDIANTE_FORM_VIEW;
	}
	

		@PostMapping("/addstudent")
		public String addEstudiante(@ModelAttribute(name="tasaModel") EstudianteModel estudianteModel,
				Model model) {
			LOG.info("METHOD: addTasa() -- PARAMS: " + estudianteModel.toString());
			
			if(null != estudianteService.addEstudiante(estudianteModel)) {
				model.addAttribute("result", 1);	
			}else {
				model.addAttribute("result", 0);
			}
			
			return "redirect:/students/showstudents";  
		}

		@GetMapping("/showstudents")
		public ModelAndView showEstudiantes() {
			ModelAndView mav = new ModelAndView(ViewConstant.ESTUDIANTES_VIEW);
			mav.addObject("estudiantes", estudianteService.listAllEstudiantes());
			return mav;
		}
		
		@GetMapping("/showstudentsbyclass")
		public String showStudentsByClass(@RequestParam(name="codClase", required=true) String codClase,
											@RequestParam(name="title", required=true) String nomClase,
											Model model) {
			
			List<EstudianteModel> estudiantesByCl = estudianteService.listEstudiantesByClase(codClase);
			model.addAttribute("estudiantesByCl",estudiantesByCl);
			model.addAttribute("nomClase",nomClase);
			return "clases :: modalClaseContents";
		}
		
		@GetMapping("/showstudentsbykeyword")
		public String showStudentsByKeyword(@RequestParam(name="keyword", required=true) String keyword,
											Model model) {
			
			List<EstudianteModel> estudiantesByKw = estudianteService.listEstudiantesSByKeyword(keyword);
			model.addAttribute("estudiantes",estudiantesByKw);
			return "estudiantes :: divEstudiantesContents";
		}
		
		@DeleteMapping("/removestudent")
		public ModelAndView removeEstudiante(@RequestParam(name="idStudent", required=true) int id) {
			estudianteService.removeEstudiante(id);
			return showEstudiantes();  
		}
		

}
