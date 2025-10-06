package es.cursogetafe.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.cursogetafe.springdata.modelo.Alumno;
import es.cursogetafe.springdata.negocio.Universidad;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private Universidad scio;
	
	@GetMapping("/listado")
	public String alumnos(Model model) {
		model.addAttribute("alumnos", scio.getAlumnos());
		return "alumnos/listado_alumnos";
	}
	
	@PostMapping("/alta_alumnos")
	public String altaAlumno(Alumno alu) {
		return "";
	}
}
