package com.estebansa.web.bicinout.app.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estebansa.web.bicinout.app.model.entity.Estudiante;

@Repository
public class EstudianteDaoImpl implements IEstudianteDao
{
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Estudiante> findAll()
	{
		return em.createQuery("from Estudiante").getResultList();
	}

}
