package com.estebansa.web.bicinout.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.estebansa.web.bicinout.app.model.entity.Funcionario;
import com.estebansa.web.bicinout.app.model.service.IFuncionarioService;

@Controller
@RequestMapping("/funcionario")
@SessionAttributes("funcionario")
public class FuncionarioController
{
	@Autowired
	private IFuncionarioService funcionarioService;

	@RequestMapping(value ="/listar", method = RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Listado de Funcionarios");
		model.addAttribute("funcionarios", funcionarioService.findAll());
		
		return "funcionario/listar";
	}
	
	@RequestMapping("/form")
	public String crear(Map<String, Object> model)
	{
		Funcionario funcionario = new Funcionario();
		
		model.put("titulo", "Formulario de registro de Funcionario");
		model.put("funcionario", funcionario);
		
		return "funcionario/form";
	}
	
	@RequestMapping("/form/{id}")
	public String editar(@PathVariable Long id, Map<String, Object> model)
	{
		Funcionario funcionario = null;
		
		if(id > 0)
		{
			funcionario = funcionarioService.findOne(id);
			
			if(funcionario == null)
			{
				return "redirect:/funcionario/listar";
			}
		}
		else
		{
			//se agrega el mensaje del redirect en el mensaje flash 
			return "redirect:/funcionario/listar";
		}
		
		model.put("funcionario", funcionario);
		model.put("titulo", "Editar Funcionario");
		
		return "funcionario/form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Funcionario funcionario, BindingResult result, Map<String, Object> model, SessionStatus status)
	{
		
		if(result.hasErrors())
		{
			Map<String, String> errores = new HashMap<>();
			
			result.getFieldErrors().forEach
			(
				err ->
				{
					errores.put(err.getField(), "El campo: ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
				}
			);
			
			model.put("titulo", "Formulario de Registro de Funcionario");
			model.put("funcionario", funcionario);
			model.put("error", errores);
			
			return "funcionario/form";
		}
		
		funcionarioService.save(funcionario);
		status.setComplete();
		
		return "redirect:/funcionario/listar";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id)
	{
		if(id > 0)
		{
			funcionarioService.delete(id);
		}
		else
		{
			System.out.println("el id del usuario no puede ser menor a cero");
			return "redirect:/funcionario/listar";
		}
		
		return "redirect:/funcionario/listar";
	}
}
