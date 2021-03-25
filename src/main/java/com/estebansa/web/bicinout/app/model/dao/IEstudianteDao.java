package com.estebansa.web.bicinout.app.model.dao;


import org.springframework.data.repository.CrudRepository;

import com.estebansa.web.bicinout.app.model.entity.Estudiante;

public interface IEstudianteDao extends CrudRepository<Estudiante, Long>
{

}
