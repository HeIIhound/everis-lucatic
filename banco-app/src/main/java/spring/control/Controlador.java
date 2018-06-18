package spring.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

	@RequestMapping("/")
	public String initForm() {
		System.out.println("Hola entro 2");
		return "index";
	}
}
