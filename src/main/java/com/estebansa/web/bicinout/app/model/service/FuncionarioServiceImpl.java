package com.estebansa.web.bicinout.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estebansa.web.bicinout.app.model.dao.IFuncionarioDao;
import com.estebansa.web.bicinout.app.model.entity.Funcionario;

@Service
public class FuncionarioServiceImpl implements IFuncionarioService
{

	@Autowired
	IFuncionarioDao funcionarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> findAll()
	{
		return funcionarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Funcionario funcionario)
	{
		funcionarioDao.save(funcionario);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario findOne(Long id)
	{
		return funcionarioDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id)
	{
		funcionarioDao.delete(id);
	}

}
