package com.estebansa.web.bicinout.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estebansa.web.bicinout.app.model.dao.IBicicletaDao;
import com.estebansa.web.bicinout.app.model.entity.Bicicleta;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;

@Service
public class BicicletaServiceImpl implements IBicicletaService
{

	@Autowired
	private IBicicletaDao bicicletaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Bicicleta> findAll()
	{
		return (List<Bicicleta>) bicicletaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Bicicleta findById(Long id)
	{
		return bicicletaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id)
	{
		bicicletaDao.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Bicicleta bicicleta)
	{
		bicicletaDao.save(bicicleta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bicicleta> findByEstudiante(Estudiante estudiante)
	{
		return bicicletaDao.findByEstudiante(estudiante);
	}

}
