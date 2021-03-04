package com.estebansa.web.bicinout.app.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante extends User implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;
	
	@Column(name="numero_identificacion")
	private String numeroIdentificacion;
	
	private String carrera;
	
	private String factultad;
	
	// List<Bicicleta>
	private boolean estado;

	public Estudiante(String nombre, String apellido)
	{
		super(nombre, apellido);
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTipoIdentificacion()
	{
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion)
	{
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion()
	{
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion)
	{
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getCarrera()
	{
		return carrera;
	}

	public void setCarrera(String carrera)
	{
		this.carrera = carrera;
	}

	public String getFactultad()
	{
		return factultad;
	}

	public void setFactultad(String factultad)
	{
		this.factultad = factultad;
	}

	public boolean isEstado()
	{
		return estado;
	}

	public void setEstado(boolean estado)
	{
		this.estado = estado;
	}

}
