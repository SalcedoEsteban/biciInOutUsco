package com.estebansa.web.bicinout.app.model.entity;

import java.util.Calendar;

public class Historial
{
	private Long id;
	private Bicicleta bicileta;
	private Estudiante estudiante;
	private Funcionario funcionario;
	private Calendar fechaEntrada;
	private Calendar fechaSalidad;
	private String horaEntrada;
	private String horaSalida;

	public Historial()
	{
		
	}
	
	public Historial(Estudiante estudiante, Bicicleta bicicleta, Funcionario funcionario)
	{
		this.estudiante = estudiante;
		this.bicileta = bicicleta;
		this.funcionario = funcionario;
	}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Bicicleta getBicileta()
	{
		return bicileta;
	}

	public void setBicileta(Bicicleta bicileta)
	{
		this.bicileta = bicileta;
	}

	public Estudiante getEstudiante()
	{
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}

	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}

	public Calendar getFechaEntrada()
	{
		return fechaEntrada;
	}

	public void setFechaEntrada(Calendar fechaEntrada)
	{
		this.fechaEntrada = fechaEntrada;
	}

	public Calendar getFechaSalidad()
	{
		return fechaSalidad;
	}

	public void setFechaSalidad(Calendar fechaSalidad)
	{
		this.fechaSalidad = fechaSalidad;
	}

	public String getHoraEntrada()
	{
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada)
	{
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSalida()
	{
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida)
	{
		this.horaSalida = horaSalida;
	}

}
