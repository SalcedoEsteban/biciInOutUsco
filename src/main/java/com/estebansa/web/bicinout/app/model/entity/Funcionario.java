package com.estebansa.web.bicinout.app.model.entity;

public class Funcionario extends User
{
	private String cargo;

	public Funcionario(String nombre, String apellido)
	{
		super(nombre, apellido);
	}

	public String getCargo()
	{
		return cargo;
	}

	public void setCargo(String cargo)
	{
		this.cargo = cargo;
	}

}
