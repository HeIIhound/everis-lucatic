package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class InitController {
	
	@GetMapping("/")
    public String index() {
        return "login";
    }
}
