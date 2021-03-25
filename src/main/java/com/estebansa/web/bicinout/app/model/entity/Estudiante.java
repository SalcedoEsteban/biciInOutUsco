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

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nombre;

	@NotBlank
	private String apellido;

	@Column(name = "tipo_identificacion")
	@NotBlank
	private String tipoIdentificacion;

	// @Column(name = "numero_identificacion")
	@NotBlank
	private String identificacion;
	
	@NotBlank
	private String codigo;

	@NotBlank
	private String carrera;

	@NotBlank
	private String facultad;

	@Column(name = "matricula_activa")
	private Boolean matriculaActiva;

	/*private Integer estado;*/

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Calendar fechaCreacion;

	@OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bicicleta> bicicletas;

	@OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Historial> historiales;

	@PrePersist
	public void prePersist()
	{
		this.fechaCreacion = Calendar.getInstance();
	}
	
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

	public String getIdentificacion()
	{
		return identificacion;
	}

	public void setIdentificacion(String identificacion)
	{
		this.identificacion = identificacion;
	}

	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public String getCarrera()
	{
		return carrera;
	}

	public void setCarrera(String carrera)
	{
		this.carrera = carrera;
	}

	public String getFacultad()
	{
		return facultad;
	}

	public void setFacultad(String facultad)
	{
		this.facultad = facultad;
	}

	public Boolean getMatriculaActiva()
	{
		return matriculaActiva;
	}

	public void setMatriculaActiva(Boolean matriculaActiva)
	{
		this.matriculaActiva = matriculaActiva;
	}
	
	/*public Integer getEstado()
	{
		return estado;
	}

	public void setEstado(Integer estado)
	{
		this.estado = estado;
	}*/

	public Calendar getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
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
