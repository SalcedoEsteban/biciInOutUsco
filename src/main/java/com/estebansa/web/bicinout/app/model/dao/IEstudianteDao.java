package com.estebansa.web.bicinout.app.model.dao;

import java.util.List;

import com.estebansa.web.bicinout.app.model.entity.Estudiante;

public interface IEstudianteDao
{
	public List<Estudiante> findAll();
}
