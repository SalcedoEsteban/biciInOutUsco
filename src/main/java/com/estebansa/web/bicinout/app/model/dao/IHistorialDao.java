package com.estebansa.web.bicinout.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estebansa.web.bicinout.app.model.entity.Bicicleta;
import com.estebansa.web.bicinout.app.model.entity.Estudiante;
import com.estebansa.web.bicinout.app.model.entity.Funcionario;
import com.estebansa.web.bicinout.app.model.entity.Historial;

public interface IHistorialDao extends JpaRepository<Historial, Long>
{
	public List<Historial> findByEstudiante(Estudiante estudiante);
	
	public List<Historial> findByFuncionario(Funcionario funcionario);
	
	public List<Historial> findByBicicleta(Bicicleta bicicleta);
}
