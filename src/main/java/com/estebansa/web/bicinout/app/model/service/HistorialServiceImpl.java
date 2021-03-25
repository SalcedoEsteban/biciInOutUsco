package com.estebansa.web.bicinout.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estebansa.web.bicinout.app.model.dao.IHistorialDao;
import com.estebansa.web.bicinout.app.model.entity.Bicicleta;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;
import com.estebansa.web.bicinout.app.model.entity.Funcionario;
import com.estebansa.web.bicinout.app.model.entity.Historial;

@Service
public class HistorialServiceImpl implements IHistorialService
{
	
	@Autowired
	private IHistorialDao historialDao;

	@Override
	@Transactional(readOnly = true)
	public List<Historial> findAll()
	{
		return historialDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Historial findById(Long id)
	{
		return historialDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id)
	{
		historialDao.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Historial historial)
	{
		historialDao.save(historial);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Historial> findByEstudiante(Estudiante estudiante)
	{
		return historialDao.findByEstudiante(estudiante);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Historial> findByFuncionario(Funcionario funcionario)
	{
		return historialDao.findByFuncionario(funcionario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Historial> findByBicicleta(Bicicleta bicicleta)
	{
		return historialDao.findByBicicleta(bicicleta);
	}

}
