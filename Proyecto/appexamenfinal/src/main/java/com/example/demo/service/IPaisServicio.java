package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Pais;

public interface IPaisServicio {
	public List<Pais> findAll();
	public void save(Pais pais);
	public Pais findById(Long id);
	public void deleteById(Long id);
}
