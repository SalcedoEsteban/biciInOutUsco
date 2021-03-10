package com.estebansa.web.bicinout.app.model.dao;


import org.springframework.data.repository.CrudRepository;

import com.estebansa.web.bicinout.app.model.entity.Funcionario;


public interface IFuncionarioDao extends CrudRepository<Funcionario, Long>
{
	
}
