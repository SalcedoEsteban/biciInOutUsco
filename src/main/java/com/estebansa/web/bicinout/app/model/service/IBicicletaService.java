package com.estebansa.web.bicinout.app.model.service;

import java.util.List;

import com.estebansa.web.bicinout.app.model.entity.Bicicleta;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;

public interface IBicicletaService
{
	public List<Bicicleta> findAll();
	
	public Bicicleta findById(Long id);
	
	public void deleteById(Long id);
	
	public void save(Bicicleta bicicleta);
	
	public List<Bicicleta> findByEstudiante(Estudiante estudiante);
}
