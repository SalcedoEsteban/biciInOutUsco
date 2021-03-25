package com.estebansa.web.bicinout.app.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;

import com.estebansa.web.bicinout.app.model.entity.Bicicleta;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;
import com.estebansa.web.bicinout.app.model.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
@SessionAttributes("estudiante")
public class EstudianteController
{
	@Autowired
	private static RestTemplate restTemplate;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping("/form")
	public String registrarEstudiante()
	{
		return "estudiante/form";
	}
	
	@GetMapping("/formConsulta")
	public String mostrarFormularioConsulta(Map<String, Object> model)
	{
		model.put("titulo", "Formulario de Consulta de Estudiante");
		
		return "estudiante/formConsulta";
	}
	
	
	@GetMapping("/consultar")
	public String consultar(@RequestParam String codigo,  Map<String, Object> model)
	{
		
		//Estudiante estudiante = new Estudiante();
		//Bicicleta bicicleta = new Bicicleta();
		
		ResponseEntity<Estudiante> responseEntity = consultar(codigo);
		
		if(responseEntity.getStatusCodeValue() == 404)
		{
			System.out.println("Error 404, no existe el estudiante en la base de datos");
		}
		else if(responseEntity.getStatusCodeValue() == 500)
		{
			System.out.println("Error 505, no se pudo realizar la consulta a la base de datos");
		}
		else if(responseEntity.getStatusCodeValue() == 200)
		{
			model.put("estudiante", responseEntity.getBody());
		}
		
		//model.put("estudiante", estudiante);
		//model.put("bicicleta", bicicleta);
		model.put("titulo", "Informacion del estudiante");
		
		return "estudiante/consulta";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Estudiante estudiante, BindingResult result, SessionStatus status, Map<String, Object> model)
	{
		if(result.hasErrors())
		{
			return "estudinate/consulta";
		}
		
		estudianteService.save(estudiante);
		status.setComplete();
		
		return "redirect:/estudiantes/listar";
	}
	
	@GetMapping("/listar")
	public String listar(Map<String, Object> model)
	{
		model.put("estudiantes", estudianteService.findAll());
		
		return "estudiante/listar";
	}
	
	public static ResponseEntity<Estudiante> consultar(String codigo)
	{
		String url = "http://localhost:8080/api/estudiantes/" + codigo;
		
		return restTemplate.getForEntity(url, Estudiante.class);
	}
	
	
	
}
