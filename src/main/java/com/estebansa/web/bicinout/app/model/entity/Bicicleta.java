package com.estebansa.web.bicinout.app.model.entity;

public class Bicicleta
{
	private Long id;
	private Estudiante estudiante;
	private String color;
	private String marca;
	private boolean candado;
	private String estado;
	private String comentario;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Estudiante getEstudiante()
	{
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getMarca()
	{
		return marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	public boolean isCandado()
	{
		return candado;
	}

	public void setCandado(boolean candado)
	{
		this.candado = candado;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	public String getComentario()
	{
		return comentario;
	}

	public void setComentario(String comentario)
	{
		this.comentario = comentario;
	}

}
