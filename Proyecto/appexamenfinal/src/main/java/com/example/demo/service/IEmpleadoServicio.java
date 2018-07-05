package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Empleado;

public interface IEmpleadoServicio {
	public List<Empleado> findAll();
	public void save(Empleado empleado);
	public Empleado findById(Long id);
	public void deleteById(Long id);
}
