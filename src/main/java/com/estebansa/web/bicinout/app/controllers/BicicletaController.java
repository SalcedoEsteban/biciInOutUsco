package com.estebansa.web.bicinout.app.controllers;

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
