package com.estebansa.web.bicinout.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.estebansa.web.bicinout.app.model.entity.Bicicleta;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;
import com.estebansa.web.bicinout.app.model.entity.Historial;
import com.estebansa.web.bicinout.app.model.service.IBicicletaService;
import com.estebansa.web.bicinout.app.model.service.IEstudianteService;

@SessionAttributes("historial")
@Controller
@RequestMapping("/historial")
public class HistorialController
{
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IBicicletaService bicicletaService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/form/{id}")
	public String form(@PathVariable Long id, Map<String, Object> model)
	{
		Historial historial = new Historial();
		Estudiante estudianteGuardado = null;
		List<Bicicleta> bicicletas = new ArrayList<>();
		boolean entrada = true;
		
		if(id > 0)
		{
			estudianteGuardado = estudianteService.findById(id);
			
			if(estudianteGuardado == null)
			{
				//se agrega el mensaje flash para mostrar en la vista de que el estudiante no existe en la base de datos
				return "redirect:/estudiantes/listar";
			}
		}
		else 
		{
			//se agrega el mensaje de que el id no puede ser menor a cero
			return "redirect:/estudiantes/listar";	
		}
		
		/** se realiza el consumo de la API REST  */
		ResponseEntity<Estudiante> estudiante = consultar(estudianteGuardado.getCodigo());
		
		/* se valida que el estudiante exista en la base de datos que consulta la API REST*/
		if(estudiante.getStatusCodeValue() == 404)
		{
			//se agrega un mensaje fla
			return "redirect:/estudiantes/listar";
		}
		if(estudiante.getStatusCodeValue() == 500)
		{
			return "redirect:/estudiantes/listar";
		}
		if(estudiante.getStatusCodeValue() == 200)
		{
			/* se actualiza el estudiante guardado en la base de datos despues de consumir el API REST*/
			estudianteService.save(estudiante.getBody());
			//ser agrega el mensaje flash de que se actualizo el estudiante
		}
		
		bicicletas = bicicletaService.findByEstudiante(estudianteGuardado);
		
		model.put("titulo", "Crear Historial a Estudiante: " + estudianteGuardado.getNombre().concat(" ").concat(estudianteGuardado.getApellido()));
		model.put("matriculaActiva", estudianteGuardado.getMatriculaActiva());
		model.put("entrada", entrada);
		model.put("historial", historial);
		model.put("bicicletas", bicicletas);
		
		return "historial/form";
	}
	
	private ResponseEntity<Estudiante> consultar(String codigo)
	{
		String url = "http://localhost:8080/api/estudiantes/" + codigo;
		
		return restTemplate.getForEntity(url, Estudiante.class);
	}
}
