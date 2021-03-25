package com.estebansa.web.bicinout.app.model.service;

import java.util.List;

import com.estebansa.web.bicinout.app.model.entity.Bicicleta;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;
import com.estebansa.web.bicinout.app.model.entity.Funcionario;
import com.estebansa.web.bicinout.app.model.entity.Historial;

public interface IHistorialService
{
	public List<Historial> findAll();
	
	public Historial findById(Long id);
	
	public void deleteById(Long id);
	
	public void save(Historial historial);
	
	public List<Historial> findByEstudiante(Estudiante estudiante);
	
	public List<Historial> findByFuncionario(Funcionario funcionario);
	
	public List<Historial> findByBicicleta(Bicicleta bicicleta);

}
