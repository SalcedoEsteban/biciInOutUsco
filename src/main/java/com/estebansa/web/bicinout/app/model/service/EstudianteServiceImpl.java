package com.estebansa.web.bicinout.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estebansa.web.bicinout.app.model.dao.IEstudianteDao;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService
{
	
	@Autowired
	private IEstudianteDao estudianteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findAll()
	{
		return (List<Estudiante>) estudianteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante findById(Long id)
	{
		return estudianteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id)
	{
		estudianteDao.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante)
	{
		estudianteDao.save(estudiante);
	}

}
