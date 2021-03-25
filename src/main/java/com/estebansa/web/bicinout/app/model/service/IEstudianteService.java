package com.estebansa.web.bicinout.app.model.service;

import java.util.List;

import com.estebansa.web.bicinout.app.model.entity.Estudiante;

public interface IEstudianteService
{
	public List<Estudiante> findAll();
	
	public Estudiante findById(Long id);
	
	public void deleteById(Long id);
	
	public void save(Estudiante estudiante);
}
