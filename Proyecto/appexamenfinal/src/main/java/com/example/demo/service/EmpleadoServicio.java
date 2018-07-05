package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleadoRepositorio;

@Service
public class EmpleadoServicio implements IEmpleadoServicio {

	@Autowired
	private EmpleadoRepositorio empleadoRepositorio;
	
	@Override
	public List<Empleado> findAll(){
		return empleadoRepositorio.findAll();
	}
	
	@Override
	public void save(Empleado empleado) {
		empleadoRepositorio.save(empleado);
	}
	
	@Override
	public Empleado findById(Long id) {
		return empleadoRepositorio.findOne(id);
	}
	
	@Override
	public void deleteById(Long id) {
		empleadoRepositorio.delete(id);
	}
}
