package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Pais;
import com.example.demo.repository.PaisRepositorio;

@Service
public class PaisServicio implements IPaisServicio {

	@Autowired
	private PaisRepositorio paisRepositorio;
	
	@Override
	public List<Pais> findAll() {
		return paisRepositorio.findAll();
	}
	
	@Override
	public void save(Pais pais) {
		paisRepositorio.save(pais);
	}
	
	@Override
	public Pais findById(Long id) {
		return paisRepositorio.findOne(id);
	}
	
	@Override
	public void deleteById(Long id) {
		paisRepositorio.delete(id);
	}
}
