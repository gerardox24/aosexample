package com.example.demo.entity;
//TODO: Mapeo Bidireccional 

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

@Entity
@Table(name = "pais")
public class Pais implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paisID;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pais",fetch = FetchType.LAZY)
	private List<Empleado> empleadoPaisCollection;
	
	public Long getPaisID() {
		return paisID;
	}

	public void setPaisID(Long paisID) {
		this.paisID = paisID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getEmpleadoPaisCollection() {
		return empleadoPaisCollection;
	}

	public void setEmpleadoPaisCollection(List<Empleado> empleadoPaisCollection) {
		this.empleadoPaisCollection = empleadoPaisCollection;
	}
}
