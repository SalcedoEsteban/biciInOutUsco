package com.estebansa.web.bicinout.app.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estebansa.web.bicinout.app.model.entity.Funcionario;

@Repository
public class FuncionarioDaoImpl implements IFuncionarioDao
{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Funcionario findOne(Long id)
	{
		return em.find(Funcionario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Funcionario> findAll()
	{
		return em.createQuery("from Funcionario").getResultList();
	}

	@Override
	@Transactional
	public void save(Funcionario funcionario)
	{
		if(funcionario.getId() != null && funcionario.getId() > 0)
		{
			em.merge(funcionario);
		}
		else
		{
			em.persist(funcionario);
		}
	}

	@Override
	@Transactional
	public void delete(Long id)
	{
		em.remove(findOne(id));
	}

}
