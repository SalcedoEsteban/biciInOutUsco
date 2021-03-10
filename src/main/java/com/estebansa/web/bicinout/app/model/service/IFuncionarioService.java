package com.estebansa.web.bicinout.app.model.service;

import java.util.List;

import com.estebansa.web.bicinout.app.model.entity.Funcionario;

public interface IFuncionarioService
{
	public List<Funcionario> findAll();
	
	public void save(Funcionario funcionario);
	
	public Funcionario findOne(Long id);
	
	public void delete(Long id);
}
