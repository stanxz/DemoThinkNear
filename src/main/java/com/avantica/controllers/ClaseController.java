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
import com.avantica.models.ClaseModel;
import com.avantica.service.ClaseService;

@Controller
@RequestMapping("/classes")
public class ClaseController {

	private static final Log LOG = LogFactory.getLog(ClaseController.class);
	
	@Autowired
	@Qualifier("claseServiceImpl")
	private ClaseService claseService;
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/classes/showclasses"; 
	}
	
	@GetMapping("/classform")
	private String redirectClaseForm(@RequestParam(name="codClase", required=false) String cod,
			Model model) {
		
		ClaseModel clase=new ClaseModel();
		if(!cod.equalsIgnoreCase("") && !cod.equalsIgnoreCase("0") ) {
			clase=claseService.findClaseByIdModel(cod);
		}
		model.addAttribute("claseModel",clase);
		return ViewConstant.CLASE_FORM_VIEW;
	}
	

		@PostMapping("/addclass")
		public String addClase(@ModelAttribute(name="claseModel") ClaseModel claseModel,
				Model model) {
			LOG.info("METHOD: addTasa() -- PARAMS: " + claseModel.toString());
			
			if(null != claseService.addClase(claseModel)) {
				model.addAttribute("result", 1);	
			}else {
				model.addAttribute("result", 0);
			}
			
			return "redirect:/classes/showclasses";  
		}

		@GetMapping("/showclasses")
		public ModelAndView showClasses() {
			ModelAndView mav = new ModelAndView(ViewConstant.CLASES_VIEW);
			mav.addObject("clases", claseService.listAllClases());
			return mav;
		}
		
		@GetMapping("/showclassesbystudent")
		public String showClassesByStudent(@RequestParam(name="idStudent", required=true) int idEstudiante,
											@RequestParam(name="firstname", required=true) String nombre,
											@RequestParam(name="lastname", required=true) String apellido,
											Model model) {
			
			List<ClaseModel> clasesBySt = claseService.listClasesByEstudiante(idEstudiante);
			model.addAttribute("clasesBySt",clasesBySt);
			model.addAttribute("nomEst", nombre + " " + apellido);
			return "estudiantes :: modalEstudianteContents";
		}
		
		@GetMapping("/showclassesbykeyword")
		public String showClassesByKeyword(@RequestParam(name="keyword", required=true) String keyword,
											Model model) {
			
			List<ClaseModel> clasesByKw = claseService.listClasesByKeyword(keyword);
			model.addAttribute("clases",clasesByKw);
			return "clases :: divClasesContents";
		}
		
		@DeleteMapping("/removeclass")
		public ModelAndView removeClass(@RequestParam(name="codClase", required=true) String cod) {
			claseService.removeClase(cod);
			return showClasses();  
		}
		

}
