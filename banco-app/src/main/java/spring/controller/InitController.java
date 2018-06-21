package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;

//import spring.services.IService;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InitController {
	
	//@Autowired
	//private IService userService;
	
	@GetMapping("/")
    public String index() {
        return "login";
    }
}
