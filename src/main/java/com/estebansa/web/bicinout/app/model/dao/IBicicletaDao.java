package com.estebansa.web.bicinout.app.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.estebansa.web.bicinout.app.model.entity.Bicicleta;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;

public interface IBicicletaDao extends CrudRepository<Bicicleta, Long>
{
	public List<Bicicleta> findByEstudiante(Estudiante estudiante);
}
