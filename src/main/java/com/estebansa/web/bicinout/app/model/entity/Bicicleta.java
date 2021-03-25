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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name = "bicicletas")
public class Bicicleta implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Estudiante estudiante;

	@NotBlank
	private String color;

	@NotBlank
	private String marca;

	@NotNull
	private boolean candado;

	private String estado;

	private String comentario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Calendar fechaCreacion;

	@OneToMany(mappedBy = "bicicleta", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Historial> historiales;

	public Bicicleta()
	{
		historiales = new ArrayList<>();
	}

	@PrePersist
	public void prePersist()
	{
		this.fechaCreacion = Calendar.getInstance();
	}

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

}
