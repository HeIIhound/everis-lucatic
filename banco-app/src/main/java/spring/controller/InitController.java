package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotationc.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Usuariologin;
import spring.services.IServicios;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

//import spring.services.IService;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InitController {
	
	@Autowired
	private IServicios userService;
	
	//UsuarioLogin
	@ModelAttribute("Usuariologin")
	public Usuariologin usuarioLoginObject() {
		
		return new Usuariologin();
	}
	
	//pagina login
	@GetMapping("/")
    public String login() {
        return "login";
    }
	
	//pagina inicio
	@RequestMapping(value = "/inicio")
	public ModelAndView inicio(HttpServletRequest request) throws Exception {
		Usuariologin u = userService.getUsuariologin("fpachecs");
		System.out.println(u.getPass());
		ModelAndView model = new ModelAndView("inicio");
		return model;
	}
}
