package com.estebansa.web.bicinout.app.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String apellido;

	@Column(name = "tipo_identificacion")
	private String tipoIdentificacion;

	@Column(name = "numero_identificacion")
	private String numeroIdentificacion;

	private String carrera;

	private String factultad;

	private boolean estado;

	@OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bicicleta> bicicletas;

	@OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Historial> historiales;

	public Estudiante()
	{
		bicicletas = new ArrayList<>();
		historiales = new ArrayList<>();
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

	public List<Bicicleta> getBicicletas()
	{
		return bicicletas;
	}

	public void setBicicletas(List<Bicicleta> bicicletas)
	{
		this.bicicletas = bicicletas;
	}

	/** metodo para agregar una bicileta a la coleccion de biciletas */
	public void addBicicleta(Bicicleta bicicleta)
	{
		bicicletas.add(bicicleta);
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
