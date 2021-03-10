package com.estebansa.web.bicinout.app.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable
{
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nombre;
	
	@NotBlank
	private String apellido;

	@NotBlank
	private String cargo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Calendar fechaCreacion;

	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Historial> historiales;

	@PrePersist
	public void prePersist()
	{
		this.fechaCreacion = Calendar.getInstance();
	}
	
	public Funcionario()
	{
		this.historiales = new ArrayList<>();
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

	public String getCargo()
	{
		return cargo;
	}

	public void setCargo(String cargo)
	{
		this.cargo = cargo;
	}

	public Calendar getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}

	public List<Historial> getHistoriales()
	{
		return historiales;
	}

	public void setHistoriales(List<Historial> historiales)
	{
		this.historiales = historiales;
	}

	public void addHistorial(Historial historial)
	{
		historiales.add(historial);
	}
}
