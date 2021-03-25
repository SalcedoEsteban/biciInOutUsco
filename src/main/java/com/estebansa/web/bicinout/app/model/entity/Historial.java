package com.estebansa.web.bicinout.app.model.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "historiales")
public class Historial implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Bicicleta bicicleta;

	@ManyToOne(fetch = FetchType.LAZY)
	private Estudiante estudiante;

	@ManyToOne(fetch = FetchType.LAZY)
	private Funcionario funcionario;

	@Column(name = "fecha_entrada")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar fechaEntrada;

	@Column(name = "fechaSalida")
	@Temporal(TemporalType.DATE)
	private Calendar fechaSalidad;

	@Column(name = "hora_entrada")
	@Temporal(TemporalType.TIME)
	private Date horaEntrada;

	@Column(name = "hora_salida")
	@Temporal(TemporalType.TIME)
	private Date horaSalida;

	@Column(name = "fechaCreacion")
	@Temporal(TemporalType.DATE)
	private Calendar fechaCreacion;

	@PrePersist
	public void prePersist()
	{
		this.fechaCreacion = Calendar.getInstance();
	}

	public Historial()
	{

	}

	public Historial(Estudiante estudiante, Bicicleta bicicleta, Funcionario funcionario)
	{
		this.estudiante = estudiante;
		this.bicicleta = bicicleta;
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
		return bicicleta;
	}

	public void setBicileta(Bicicleta bicileta)
	{
		this.bicicleta = bicileta;
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

	public Date getHoraEntrada()
	{
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada)
	{
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSalida()
	{
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida)
	{
		this.horaSalida = horaSalida;
	}

	public Calendar getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}

}
