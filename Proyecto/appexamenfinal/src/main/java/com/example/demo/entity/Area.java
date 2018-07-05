package com.example.demo.entity;

import java.io.Serializable;
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

//TODO: Mapeo Bidireccional 
@Entity
@Table(name = "area")
public class Area implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long areaID;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "area",fetch = FetchType.LAZY)
	private List<Empleado> empleadoAreaCollection;

	public Long getAreaID() {
		return areaID;
	}

	public void setAreaID(Long areaID) {
		this.areaID = areaID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getEmpleadoAreaCollection() {
		return empleadoAreaCollection;
	}

	public void setEmpleadoAreaCollection(List<Empleado> empleadoAreaCollection) {
		this.empleadoAreaCollection = empleadoAreaCollection;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
