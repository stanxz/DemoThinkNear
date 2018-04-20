package com.avantica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avantica.constant.ViewConstant;

@Controller
@RequestMapping("/inicio")
public class InicioController {

	@GetMapping("/home")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView(ViewConstant.INICIAL);
//		mav.addObject("productosmodels", productoService.listAllProductos());
//		mav.addObject("evaluacionModel", new EvaluacionModel());
		return mav;
	}
	
	@GetMapping("/")
	public String redireccionaInicio() {
		return "redirect:/inicio/home"; 
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/inicio/home"; 
	}
	
}
