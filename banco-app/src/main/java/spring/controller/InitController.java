package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import spring.services.IService;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InitController {
	
	//@Autowired
	//private IService userService;
	
	@GetMapping("/")
    public String login() {
        return "login";
    }
	
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public ModelAndView inicio() throws Exception {
		ModelAndView model = new ModelAndView("inicio");
		return model;
	}
}
