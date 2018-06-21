package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String handleRequest() throws Exception {
		System.out.println("----Dentro del Controller");
		return "index";
	}
	

}
