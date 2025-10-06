package es.cursogetafe.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	@GetMapping("/menu")
	public String menuPrincipal() {
		System.out.println("menu");
		return "menu_principal";
	}
}
