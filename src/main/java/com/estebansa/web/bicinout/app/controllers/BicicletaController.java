package com.estebansa.web.bicinout.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.estebansa.web.bicinout.app.model.entity.Bicicleta;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;
import com.estebansa.web.bicinout.app.model.service.IBicicletaService;
import com.estebansa.web.bicinout.app.model.service.IEstudianteService;

@SessionAttributes("bicicleta")
@Controller
@RequestMapping("/bicicleta")
public class BicicletaController
{
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IBicicletaService bicicletaService;
	
	@GetMapping("/form/{id}")
	public String form(@PathVariable Long id, Map<String, Object> model)
	{
		Bicicleta bicicleta = new Bicicleta();
		Estudiante estudiante = null;
		
		if(id > 0)
		{
			estudiante = estudianteService.findById(id);
			
			if(estudiante == null)
			{
				//se agrega el mensaje flash de que el estudiante no existe en al base de datos 
				return "redirect:/estudiantes/listar";
			}
		}
		else
		{
			//se agrega el mensaje flash de que el id no puede ser menor a cero
			return "redirect:/estudiantes/listar";
		}
		
		bicicleta.setEstudiante(estudiante);
		
		//model.put("estudiante", estudiante);
		model.put("bicicleta", bicicleta);
		model.put("titulo", "Fomulario de registro de Bicicleta para el estudiante: " + estudiante.getNombre() +
				" " + estudiante.getApellido());
		
		return "bicicleta/form";
	}
	
	@GetMapping("/buscar/{idEstudiante}")
	public String buscar(@PathVariable Long idEstudiante, Map<String, Object> model)
	{
		Estudiante estudiante = null;
		List<Bicicleta> bicicletas = new ArrayList<>();
		
		if(idEstudiante > 0)
		{
			estudiante = estudianteService.findById(idEstudiante);
			
			if(estudiante == null)
			{
				//se agrega mensaje flash de que el estudiante no existe en la base de datos y se redirige a la url especificada
				return "redirect:/estudiantes/listar";
			}
		}
		else
		{
			//se agrega mensaje flash de que el id no puede ser menor a cero y se redirige a la url especificada
			return "redirect:/estudiantes/listar";
		}
		
		bicicletas = bicicletaService.findByEstudiante(estudiante);
		
		model.put("bicicletas", bicicletas);
		model.put("titulo", "Bicicletas asignadas al estudiante: ".concat(estudiante.getNombre()).concat(" con codigo: ") + estudiante.getCodigo());
		
		return "bicicleta/listar";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Bicicleta bicicleta, BindingResult result, SessionStatus status, Map<String, Object> model)
	{
		if(result.hasErrors())
		{
			model.put("titulo", "Fomulario de registro de Bicicleta para el estudiante: " + bicicleta.getEstudiante().getNombre() +
				" " + bicicleta.getEstudiante().getApellido());
			
			return "bicicleta/form";
		}
		
		bicicletaService.save(bicicleta);
		status.setComplete();
		
		return "redirect:/estudiantes/listar";
	}
}
