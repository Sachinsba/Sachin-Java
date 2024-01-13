package com.VaccinationCenter.Controller;

import java.util.logging.Logger;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

	Logger log = Logger.getAnonymousLogger();
	
	@RequestMapping("/")
	public ModelAndView basepage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		log.info("login page");
	
		mv.setViewName("redirect:/admin/login");
		return mv;
	}
}
