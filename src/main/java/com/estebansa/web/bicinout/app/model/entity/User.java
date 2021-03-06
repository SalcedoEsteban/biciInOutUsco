package com.estebansa.web.bicinout.app.model.entity;


public class User
{
	private Long id;
	
	private String nombre;
	
	private String apellido;

	public User()
	{
		
	}

	public User(String nombre, String apellido)
	{
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getApellido()
	{
		return apellido;
	}

	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

}
